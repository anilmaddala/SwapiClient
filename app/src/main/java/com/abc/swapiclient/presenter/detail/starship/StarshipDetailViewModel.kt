package com.abc.swapiclient.presenter.detail.starship

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Starship
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.presenter.util.buildURLMap
import com.abc.swapiclient.usecases.GetStarshipUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StarshipDetailViewModel @ViewModelInject constructor(private val getStarshipUseCase: GetStarshipUseCase) :
    ViewModel() {

    companion object {
        private const val FILMS = "films"
        private const val PEOPLE = "people"
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    private val _starshipResponse = MutableLiveData<State<Starship>>()

    val loading: LiveData<Boolean>
        get() = _starshipResponse.map { it is State.Loading }

    val starship: LiveData<Starship>
        get() = _starshipResponse.map { if (it is State.Success) it.data else Starship() }

    val filmsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("films:", "films", _starshipResponse)
        }

    val pilotsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("pilots:", "pilots", _starshipResponse)
        }

    fun onURLClick(): (url: String) -> Unit {
        return {
            setNextNavigation(it)
        }
    }


    /**
     * Load StarWars Character
     */
    fun loadStarship(id: String) {
        viewModelScope.launch {
            getStarshipUseCase.invoke(id).collect {
                _starshipResponse.value = it
            }
        }
    }

    // TODO: ViewModel shouldn't have any view related components. Move to fragment or activity
    /**
     * Process URL and navigate to appropriate fragment destination
     * Sample URL: 'http://swapi.dev/api/starships/1/'
     */
    private fun setNextNavigation(url: String) {
        val splits = url.split('/')
        val id = splits[splits.lastIndex - 1]
        when (splits[splits.lastIndex - 2]) {
            FILMS -> {
                _navigationAction.postValue(
                    StarshipDetailFragmentDirections.actionStarshipDetailFragmentToFilmDetailFragment(
                        id
                    )
                )
            }
            PEOPLE -> {
                _navigationAction.postValue(
                    StarshipDetailFragmentDirections.actionStarshipDetailFragmentToPersonDetailFragment(
                        id
                    )
                )
            }
        }
    }
}