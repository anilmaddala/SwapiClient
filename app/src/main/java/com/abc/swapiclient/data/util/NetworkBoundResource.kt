package com.abc.swapiclient.data.util

import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<T> {

    fun asFlow(): Flow<Resource<T>> = flow {
        val flow = query()
            .onStart { emit(Resource.loading<T>(null)) }
            .flatMapConcat { data ->
                if (shouldFetch(data)) {
                    emit(Resource.loading(data))

                    try {
                        saveFetchResult(fetch())
                        query().map { Resource.success(it) }
                    } catch (throwable: Throwable) {
                        onFetchFailed(throwable)
                        query().map { Resource.error(throwable, it) }
                    }
                } else {
                    query().map { Resource.success(it) }
                }
            }

        emitAll(flow)
    }

    abstract fun query(): Flow<T>

    abstract suspend fun fetch(): T

    abstract suspend fun saveFetchResult(data: T)

    open fun onFetchFailed(throwable: Throwable) = Unit

    open fun shouldFetch(data: T) = true
}