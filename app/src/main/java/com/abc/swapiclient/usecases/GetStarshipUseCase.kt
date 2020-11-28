package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Starship
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for getting Starship based on starship id
 */
class GetStarshipUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(id: String): Flow<State<Starship>> {
        return repository.getStarship(id)
    }
}