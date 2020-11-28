package com.abc.swapiclient.presenter.detail.film

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Film
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.usecases.GetFilmUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FilmDetailViewModel @ViewModelInject constructor(private val getFilmUseCase: GetFilmUseCase) :
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

    private val _filmResponse = MutableLiveData<State<Film>>()

    val loading: LiveData<Boolean>
        get() = _filmResponse.map { it is State.Loading }

    val film: LiveData<Film>
        get() = _filmResponse.map { if (it is State.Success) it.data else Film() }

    val listDataHeader: LiveData<List<String>>
        get() {
            return _filmResponse.map {
                if (it is State.Success) {
                    val list = ArrayList<String>()
                    if (it.data.characters?.isNotEmpty() == true) {
                        list.add("Characters:")
                    }
                    list
                } else {
                    ArrayList()
                }
            }
        }

    val listDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return _filmResponse.map {
                if (it is State.Success) {
                    val map = HashMap<String, List<String>>()
                    val list = ArrayList<String>()
                    if (it.data.characters?.isNotEmpty() == true) {
                        it.data.characters.forEach { url ->
                            list.add(url)
                        }
                        map["Characters:"] = list
                    }
                    map
                } else {
                    HashMap()
                }
            }
        }

    fun onURLClick(): (url: String) -> Unit {
        return {
            setNextNavigation(it)
        }
    }


    /**
     * Load StarWars Character
     */
    fun loadFilm(id: String) {
        viewModelScope.launch {
            getFilmUseCase.invoke(id).collect {
                _filmResponse.value = it
            }
        }
    }

    // TODO: ViewModel shouldn't have any view related components. Move to fragment or activity
    /**
     * Process URL and navigate to appropriate fragment destination
     * Sample URL: 'http://swapi.dev/api/planets/1/'
     */
    fun setNextNavigation(url: String) {
        val splits = url.split('/')
        val id = splits[splits.lastIndex - 1]
        when (splits[splits.lastIndex - 2]) {
            FILMS -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentSelf(
                        id
                    )
                )
            }
            PEOPLE -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentToPersonDetailFragment(
                        id
                    )
                )
            }
            PLANETS -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentToPlanetDetailFragment(
                        id
                    )
                )
            }
            SPECIES -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentToSpeciesDetailFragment(
                        id
                    )
                )
            }
            STARSHIPS -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentToStarshipDetailFragment(
                        id
                    )
                )
            }
            VEHICLES -> {
                _navigationAction.postValue(
                    FilmDetailFragmentDirections.actionFilmDetailFragmentToVehicleDetailFragment(
                        id
                    )
                )
            }
        }
    }
}