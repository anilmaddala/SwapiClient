package com.abc.swapiclient.presenter.detail.person

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.usecases.GetPersonUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PersonDetailViewModel @ViewModelInject constructor(getPersonUseCase: GetPersonUseCase) : ViewModel() {

    val id = "1"

    private var _person = MutableLiveData<Person>()
    val person: LiveData<Person>
        get() = _person

    init {
        viewModelScope.launch {
            getPersonUseCase.invoke(id).collect {
                Log.v("MVS", it.toString())
            }
        }
    }


}