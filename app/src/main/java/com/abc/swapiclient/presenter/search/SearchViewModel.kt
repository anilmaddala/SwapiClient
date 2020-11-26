package com.abc.swapiclient.presenter.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel @ViewModelInject constructor() : ViewModel() {

    var mediator = MediatorLiveData<Void>()

    private var _searchQuery = MutableLiveData<String>()

    init {
        mediator.addSource(_searchQuery) { query -> searchPeople(query) }
    }


    fun onSearchQuerySubmitted(query: String): Boolean {
        _searchQuery.value = query
        return true
    }

    private fun searchPeople(query: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}