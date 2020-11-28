package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.models.PersonSearchResult
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for searching People based on a search query
 */
class SearchPeopleUseCase @Inject constructor(private val repository: RepositoryImpl){
suspend operator fun invoke(query: String, pageIndex: Int): Flow<State<PersonSearchResult>> {
    return repository.searchPeople(query, pageIndex)
}
}