package com.abc.swapiclient.presenter.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.usecases.GetPersonUseCase
import com.abc.swapiclient.usecases.SearchPeopleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(private val searchPeopleUseCase: SearchPeopleUseCase) : ViewModel() {

    var mediator = MediatorLiveData<Void>()

    private var _searchQuery = MutableLiveData<String>()

    private val _personListResponse = MutableLiveData<State<List<Person>>>()

    val peopleList: LiveData<List<Person>>
        get() = _personListResponse.map { if (it is State.Success) it.data else ArrayList() }

    init {
        mediator.addSource(_searchQuery) { query -> searchPeople(query) }
    }


    fun onSearchQuerySubmitted(query: String): Boolean {
        _searchQuery.value = query
        return true
    }

    private fun searchPeople(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchPeopleUseCase.invoke(query).collect {
                _personListResponse.value = it
            }
        }
    }
}