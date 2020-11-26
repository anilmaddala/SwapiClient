package com.abc.swapiclient.presenter.detail.person

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abc.swapiclient.domain.Person

class PersonDetailViewModel @ViewModelInject constructor() : ViewModel() {

    private var _person = MutableLiveData<Person>()
    val person: LiveData<Person>
        get() = _person
}