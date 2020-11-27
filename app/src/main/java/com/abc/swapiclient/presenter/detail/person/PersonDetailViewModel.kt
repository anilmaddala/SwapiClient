package com.abc.swapiclient.presenter.detail.person

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import com.abc.swapiclient.usecases.GetPersonUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PersonDetailViewModel @ViewModelInject constructor(getPersonUseCase: GetPersonUseCase) : ViewModel() {

    val id = "1"

    private val _response = MutableLiveData<State<Person>>()
//        .map {
//            when(it) {
//                State.Loading -> {
//                    Log.v("MVS", "Loading")
//                }
//                is State.Success -> {
//                    Log.v("MVS", "Success")
//                }
//                is State.Error -> {
//                    Log.v("MVS", "Error")
//                }
//            }
//        }
//    val response: LiveData<List<EmployeeListItem>>
//        get() = _response.map { if (it is State.Success) it.data else emptyList() }

    private var _person = MutableLiveData<Person>()
    val person: LiveData<Person>
        get() = _person

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getPersonUseCase.invoke(id).collect {
                Log.v("MVS", it.toString())
                _response.postValue(it)
            }
        }
    }


}