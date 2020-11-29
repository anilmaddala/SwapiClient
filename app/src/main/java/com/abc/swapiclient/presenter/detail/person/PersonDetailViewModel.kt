package com.abc.swapiclient.presenter.detail.person

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.presenter.util.buildURLMap
import com.abc.swapiclient.usecases.GetPersonUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PersonDetailViewModel @ViewModelInject constructor(private val getPersonUseCase: GetPersonUseCase) :
    ViewModel() {

    companion object {
        private const val FILMS = "films"
        private const val PEOPLE = "people"
        private const val PLANETS = "planets"
        private const val SPECIES = "species"
        private const val STARSHIPS = "starships"
        private const val VEHICLES = "vehicles"
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    private val _personResponse = MutableLiveData<State<Person>>()

    val loading: LiveData<Boolean>
        get() = _personResponse.map { it is State.Loading }

    val person: LiveData<Person>
        get() = _personResponse.map { if (it is State.Success) it.data else Person() }

    val filmsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("films:", "films", _personResponse)
        }

    val speciesListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("species:", "species", _personResponse)
        }

    val starshipsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("starships:", "starships", _personResponse)
        }

    val vehiclesListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return buildURLMap("vehicles:", "vehicles", _personResponse)
        }

    fun onURLClick(): (url: String) -> Unit {
        return {
            setNextNavigation(it)
        }
    }


    /**
     * Load StarWars Character
     */
    fun loadPerson(id: String) {
        viewModelScope.launch {
            getPersonUseCase.invoke(id).collect {
                _personResponse.value = it
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
                    PersonDetailFragmentDirections.actionPersonDetailFragmentToFilmDetailFragment(
                        id
                    )
                )
            }
            PEOPLE -> {
                _navigationAction.postValue(
                    PersonDetailFragmentDirections.actionPersonDetailFragmentSelf(
                        id
                    )
                )
            }
            PLANETS -> {
                _navigationAction.postValue(
                    PersonDetailFragmentDirections.actionPersonDetailFragmentToPlanetDetailFragment(
                        id
                    )
                )
            }
            SPECIES -> {
                _navigationAction.postValue(
                    PersonDetailFragmentDirections.actionPersonDetailFragmentToSpeciesDetailFragment(
                        id
                    )
                )
            }
            STARSHIPS -> {
                _navigationAction.postValue(
                    PersonDetailFragmentDirections.actionPersonDetailFragmentToStarshipDetailFragment(
                        id
                    )
                )
            }
            VEHICLES -> {
                _navigationAction.postValue(
                    PersonDetailFragmentDirections.actionPersonDetailFragmentToVehicleDetailFragment(
                        id
                    )
                )
            }
        }
    }
}