package com.abc.swapiclient.presenter.detail.vehicle

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Vehicle
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.usecases.GetVehicleUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VehicleDetailViewModel @ViewModelInject constructor(private val getVehicleUseCase: GetVehicleUseCase) :
    ViewModel() {

    companion object {
        private const val FILMS = "films"
        private const val PILOTS = "pilots"
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    private val _vehicleResponse = MutableLiveData<State<Vehicle>>()

    val loading: LiveData<Boolean>
        get() = _vehicleResponse.map { it is State.Loading }

    val vehicle: LiveData<Vehicle>
        get() = _vehicleResponse.map { if (it is State.Success) it.data else Vehicle() }

    val listDataHeader: LiveData<List<String>>
        get() {
            return _vehicleResponse.map {
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
            return _vehicleResponse.map {
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
    fun loadVehicle(id: String) {
        viewModelScope.launch {
            getVehicleUseCase.invoke(id).collect {
                _vehicleResponse.value = it
            }
        }
    }

    // TODO: ViewModel shouldn't have any view related components. Move to fragment or activity
    /**
     * Process URL and navigate to appropriate fragment destination
     * Sample URL: 'http://swapi.dev/api/vehicles/1/'
     */
    private fun setNextNavigation(url: String) {
        val splits = url.split('/')
        val id = splits[splits.lastIndex - 1]
        when (splits[splits.lastIndex - 2]) {
            FILMS -> {
                _navigationAction.postValue(
                    VehicleDetailFragmentDirections.actionVehicleDetailFragmentToFilmDetailFragment(
                        id
                    )
                )
            }
            PILOTS -> {
                _navigationAction.postValue(
                    VehicleDetailFragmentDirections.actionVehicleDetailFragmentToPersonDetailFragment(
                        id
                    )
                )
            }
        }
    }
}