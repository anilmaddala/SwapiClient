package com.abc.data.repository

import com.abc.data.inmemory.InMemoryPeopleDataSource
import com.abc.data.local.LocalPeopleDataSource
import com.abc.data.network.NetworkPeopleDataSource
import javax.inject.Inject


class PeopleRepository
@Inject constructor(
    private val inMemoryPeopleDataSource: InMemoryPeopleDataSource,
    private val localPeopleDataSource: LocalPeopleDataSource,
    private val networkPeopleDataSource: NetworkPeopleDataSource
) {
    suspend fun searchPeople(searchQuery: String) =
        inMemoryPeopleDataSource.searchPeople(searchQuery)
}