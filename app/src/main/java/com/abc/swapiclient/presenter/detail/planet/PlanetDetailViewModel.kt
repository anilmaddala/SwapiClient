package com.abc.swapiclient.presenter.detail.planet

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Planet
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.presenter.util.buildURLMap
import com.abc.swapiclient.usecases.GetPlanetUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlanetDetailViewModel @ViewModelInject constructor(private val getPlanetUseCase: GetPlanetUseCase) :
    ViewModel() {

    companion object {
        private const val FILMS = "films"
        private const val PEOPLE = "people"
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    private val _planetResponse = MutableLiveData<State<Planet>>()

    val loading: LiveData<Boolean>
        get() = _planetResponse.map { it is State.Loading }

    val planet: LiveData<Planet>
        get() = _planetResponse.map { if (it is State.Success) it.data else Planet() }

    val filmsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("films:", "films", _planetResponse)
        }

    val residentsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("residents:", "residents", _planetResponse)
        }

    fun onURLClick(): (url: String) -> Unit {
        return {
            setNextNavigation(it)
        }
    }


    /**
     * Load StarWars Character
     */
    fun loadPlanet(id: String) {
        viewModelScope.launch {
            getPlanetUseCase.invoke(id).collect {
                _planetResponse.value = it
            }
        }
    }

    // TODO: ViewModel shouldn't have any view related components. Move to fragment or activity
    /**
     * Process URL and navigate to appropriate fragment destination
     * Sample URL: 'http://swapi.dev/api/planets/1/'
     */
    private fun setNextNavigation(url: String) {
        val splits = url.split('/')
        val id = splits[splits.lastIndex - 1]
        when (splits[splits.lastIndex - 2]) {
            FILMS -> {
                _navigationAction.postValue(
                    PlanetDetailFragmentDirections.actionPlanetDetailFragmentToFilmDetailFragment(
                        id
                    )
                )
            }
            PEOPLE -> {
                _navigationAction.postValue(
                    PlanetDetailFragmentDirections.actionPlanetDetailFragmentToPersonDetailFragment(
                        id
                    )
                )
            }
        }
    }
}