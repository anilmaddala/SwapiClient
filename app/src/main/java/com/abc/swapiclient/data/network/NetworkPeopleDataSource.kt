package com.abc.swapiclient.data.network

import com.abc.swapiclient.domain.*

interface NetworkPeopleDataSource {
    suspend fun searchPeople(searchQuery: String)

    suspend fun getFilm(name: String)

    suspend fun getPerson(name: String)

    suspend fun getPlanet(name: String)

    suspend fun getSpecies(name: String)

    suspend fun getStarship(name: String)

    suspend fun getVehicle(name: String)

    suspend fun addFilm(film: Film)
}