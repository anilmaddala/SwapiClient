package com.abc.swapiclient.domain

import com.abc.swapiclient.domain.models.*
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun searchPeople(searchQuery: String)

    suspend fun getFilm(id: String): Flow<State<Film>>

    suspend fun getPerson(id: String): Flow<State<Person>>

    suspend fun getPlanet(id: String): Flow<State<Planet>>

    suspend fun getSpecies(id: String): Flow<State<Species>>

    suspend fun getStarship(id: String): Flow<State<Starship>>

    suspend fun getVehicle(id: String): Flow<State<Vehicle>>
}