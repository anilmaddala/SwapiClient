package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * UseCase for getting Person based on person id
 */
class GetPersonUseCase @Inject constructor(private val repository: RepositoryImpl) {
    @ExperimentalCoroutinesApi
    suspend operator fun invoke(id: String): Flow<State<Person>> {
        return repository.getPerson(id)
            .onStart { emit(State.Loading) }
            .catch { e -> emit(State.Error(Exception(e))) }
            .map { it }
            .flowOn(Dispatchers.IO)
    }
}