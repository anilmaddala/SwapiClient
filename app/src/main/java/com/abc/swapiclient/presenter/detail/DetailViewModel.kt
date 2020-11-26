package com.abc.swapiclient.presenter.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count : LiveData<Int>
        get() = _count
}