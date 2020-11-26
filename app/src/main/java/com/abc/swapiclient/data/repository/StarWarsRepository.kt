package com.abc.swapiclient.data.repository

import com.abc.swapiclient.data.local.LocalPeopleDataSource
import com.abc.swapiclient.data.network.NetworkPeopleDataSource
import com.abc.swapiclient.domain.Film
import javax.inject.Inject


class StarWarsRepository
@Inject constructor(
    private val localPeopleDataSource: LocalPeopleDataSource,
    private val networkPeopleDataSource: NetworkPeopleDataSource
) {
    suspend fun searchPeople(searchQuery: String) {
        networkPeopleDataSource.searchPeople(searchQuery)
    }

    suspend fun getFilm(name: String) {

    }

    suspend fun getPerson(name: String) {

    }

    suspend fun getPlanet(name: String) {

    }

    suspend fun getSpecies(name: String) {

    }

    suspend fun getStarship(name: String) {

    }

    suspend fun getVehicle(name: String) {

    }
}