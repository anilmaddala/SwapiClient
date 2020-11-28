package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Vehicle
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for getting Vehicle based on vehicle id
 */
class GetVehicleUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(id: String): Flow<State<Vehicle>> {
        return repository.getVehicle(id)
    }
}