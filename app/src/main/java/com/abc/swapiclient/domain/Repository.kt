package com.abc.swapiclient.domain

import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun searchPeople(searchQuery: String)

    suspend fun getFilm(name: String)

    suspend fun getPerson(name: String) : Flow<State<Person>>

    suspend fun getPlanet(name: String)

    suspend fun getSpecies(name: String)

    suspend fun getStarship(name: String)

    suspend fun getVehicle(name: String)
}