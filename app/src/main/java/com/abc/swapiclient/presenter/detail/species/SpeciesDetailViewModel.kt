package com.abc.swapiclient.presenter.detail.species

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Species
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
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

    val listDataHeader: LiveData<List<String>>
        get() {
            return _speciesResponse.map {
                if (it is State.Success) {
                    val list = ArrayList<String>()
                    if (it.data.films?.isNotEmpty() == true) {
                        list.add("Films:")
                    }
                    list
                } else {
                    ArrayList()
                }
            }
        }

    val filmsListDataChild: LiveData<HashMap<String, List<String>>>
        get() {
            return _speciesResponse.map {
                if (it is State.Success) {
                    val map = HashMap<String, List<String>>()
                    val list = ArrayList<String>()
                    if (it.data.films?.isNotEmpty() == true) {
                        it.data.films.forEach { url ->
                            list.add(url)
                        }
                        map["Films:"] = list
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
     * Sample URL: 'http://swapi.dev/api/speciess/1/'
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