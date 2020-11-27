package com.abc.swapiclient.usecases

import androidx.lifecycle.LiveData
import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPersonUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(name: String): Flow<State<Person>> {
        return repository.getPerson(name)
    }
}