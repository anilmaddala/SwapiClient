package com.abc.swapiclient.presenter.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.models.PersonSearchResult
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.presenter.util.SingleLiveEvent
import com.abc.swapiclient.usecases.SearchPeopleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor(private val searchPeopleUseCase: SearchPeopleUseCase) :
    ViewModel() {

    companion object {
        const val MIN_PAGE_INDEX = 1
    }

    private var currentPageIndex = MIN_PAGE_INDEX

    var mediator = MediatorLiveData<Void>()

    private var _searchQuery = MutableLiveData<String>()

    private val _personSearchResponse = MutableLiveData<State<PersonSearchResult>>()

    val loading: LiveData<Boolean>
        get() = _personSearchResponse.map { it is State.Loading }

    private var _previousPageURL = Transformations.map(_personSearchResponse) {
        if (it is State.Success) it.data.previous ?: "" else ""
    }

    private val _nextPageURL = Transformations.map(_personSearchResponse) {
        if (it is State.Success) it.data.next ?: "" else ""
    }

    private val _navigationAction = SingleLiveEvent<NavDirections>()
    val navigationAction: LiveData<NavDirections>
        get() = _navigationAction

    val peopleList: LiveData<List<Person>>
        get() = _personSearchResponse.map {
            if (it is State.Success) it.data.personList ?: ArrayList() else ArrayList()
        }

    init {
        mediator.addSource(_searchQuery) { query -> searchPeople(query, currentPageIndex) }
        mediator.addSource(_previousPageURL){}
        mediator.addSource(_nextPageURL){}
    }


    fun onSearchQuerySubmitted(query: String): Boolean {
        _searchQuery.value = query
        return true
    }

    fun onSearchResultClick(): (id: String) -> Unit {
        return {
            _navigationAction.postValue(
                SearchFragmentDirections.actionSearchFragmentToPersonDetailFragment(it)
            )
        }
    }

    /**
     * Load Next Page
     */
    fun loadNextPage() {
        if(_nextPageURL.value.isNullOrEmpty()) {
            return
        }
        searchPeople(getQueryFromURL(_nextPageURL.value!!), getIndexFromURL(_nextPageURL.value!!))
    }

    /**
     * Load Previous Page
     */
    fun loadPreviousPage() {
        if(_previousPageURL.value.isNullOrEmpty()) {
            return
        }
        searchPeople(getQueryFromURL(_previousPageURL.value!!), getIndexFromURL(_previousPageURL.value!!))
    }

    /**
     * Get Query from URL
     * Sample URL: http://swapi.dev/api/people/?search=r&page=2
     */
    private fun getQueryFromURL(url: String): String {
        return url.split("/").last().substringAfter("?search=").substringBefore("&")
    }

    /**
     * Get page index from URL
     * Sample URL: http://swapi.dev/api/people/?search=r&page=2
     */
    private fun getIndexFromURL(url: String): Int {
        return Integer.valueOf(url.split("/").last().substringAfter("page="))
    }

    /**
     * Search based on query and page Index
     */
    private fun searchPeople(query: String, pageIndex: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            searchPeopleUseCase.invoke(query, pageIndex).collect {
                _personSearchResponse.postValue(it)
            }
        }
    }
}