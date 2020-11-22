package com.abc.data.inmemory

/**
 * This is a in-memory data source used for development.
 */
interface InMemoryPeopleDataSource {
    suspend fun getPeopleByName(name : String)

    suspend fun searchPeople(searchQuery : String)

    suspend fun getTotalPeopleInMemory() : Int
}