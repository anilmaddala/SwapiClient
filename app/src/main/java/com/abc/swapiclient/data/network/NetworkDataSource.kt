package com.abc.swapiclient.data.network

import com.abc.swapiclient.data.network.vo.People
import com.abc.swapiclient.domain.models.Film
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkDataSource {
    suspend fun searchPeople(searchQuery: String)

    suspend fun getFilm(name: String)

    @GET("people/{id}")
    fun getPeople(@Path("id") id: String): People

    suspend fun getPlanet(name: String)

    suspend fun getSpecies(name: String)

    suspend fun getStarship(name: String)

    suspend fun getVehicle(name: String)

    suspend fun addFilm(film: Film)
}