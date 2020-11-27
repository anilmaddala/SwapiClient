package com.abc.swapiclient.domain.state

/**
 * Represents the state of data
 */
sealed class State<out T> {
    data class Success<out T>(val data: T) : State<T>()
    data class Error(val exception: Exception? = null, val message: String? = null) : State<Nothing>()
    object Loading : State<Nothing>()
}
