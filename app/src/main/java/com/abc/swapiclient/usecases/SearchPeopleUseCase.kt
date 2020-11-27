package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPeopleUseCase @Inject constructor(private val repository: RepositoryImpl){
suspend operator fun invoke(query: String): Flow<State<List<Person>>> {
    return repository.searchPeople(query)
}
}