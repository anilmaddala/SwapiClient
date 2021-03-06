package com.abc.swapiclient.presenter.detail.species

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Species
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.presenter.util.buildURLMap
import com.abc.swapiclient.usecases.GetSpeciesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SpeciesDetailViewModel @ViewModelInject constructor(private val getSpeciesUseCase: GetSpeciesUseCase) :
    ViewModel() {

    companion object {
        private const val FILMS = "films"
        private const val PEOPLE = "people"
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    private val _speciesResponse = MutableLiveData<State<Species>>()

    val loading: LiveData<Boolean>
        get() = _speciesResponse.map { it is State.Loading }

    val species: LiveData<Species>
        get() = _speciesResponse.map { if (it is State.Success) it.data else Species() }

    val filmsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("films:", "films", _speciesResponse)
        }

    val peopleListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("people:", "people", _speciesResponse)
        }

    fun onURLClick(): (url: String) -> Unit {
        return {
            setNextNavigation(it)
        }
    }


    /**
     * Load StarWars Character
     */
    fun loadSpecies(id: String) {
        viewModelScope.launch {
            getSpeciesUseCase.invoke(id).collect {
                _speciesResponse.value = it
            }
        }
    }

    // TODO: ViewModel shouldn't have any view related components. Move to fragment or activity
    /**
     * Process URL and navigate to appropriate fragment destination
     * Sample URL: 'http://swapi.dev/api/species/1/'
     */
    private fun setNextNavigation(url: String) {
        val splits = url.split('/')
        val id = splits[splits.lastIndex - 1]
        when (splits[splits.lastIndex - 2]) {
            FILMS -> {
                _navigationAction.postValue(
                    SpeciesDetailFragmentDirections.actionSpeciesDetailFragmentToFilmDetailFragment(
                        id
                    )
                )
            }
            PEOPLE -> {
                _navigationAction.postValue(
                    SpeciesDetailFragmentDirections.actionSpeciesDetailFragmentToPersonDetailFragment(
                        id
                    )
                )
            }
        }
    }
}