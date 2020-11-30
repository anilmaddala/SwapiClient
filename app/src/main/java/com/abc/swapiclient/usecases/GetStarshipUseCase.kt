package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Starship
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * UseCase for getting Starship based on starship id
 */
class GetStarshipUseCase @Inject constructor(private val repository: RepositoryImpl) {
    @ExperimentalCoroutinesApi
    suspend operator fun invoke(id: String): Flow<State<Starship>> {
        return repository.getStarship(id)
            .onStart { emit(State.Loading) }
            .catch { e -> emit(State.Error(Exception(e))) }
            .map { it }
            .flowOn(Dispatchers.IO)
    }
}