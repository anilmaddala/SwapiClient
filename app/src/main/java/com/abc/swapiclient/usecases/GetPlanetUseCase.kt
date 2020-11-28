package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Planet
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for getting Planet based on planet id
 */
class GetPlanetUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(id: String): Flow<State<Planet>> {
        return repository.getPlanet(id)
    }
}