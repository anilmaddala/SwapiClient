package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Species
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for getting Species based on species id
 */
class GetSpeciesUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(id: String): Flow<State<Species>> {
        return repository.getSpecies(id)
    }
}