package com.abc.swapiclient.data.network

import com.abc.swapiclient.data.network.vo.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkDataSource {

    @GET("people")
    suspend fun searchPeople(
        @Query("search") searchQuery: String,
        @Query("page") pageNumber: Int = 1
    ): PeopleSearchResponse

    @GET("films/{id}")
    suspend fun getFilm(@Path("id") id: String): Films

    @GET("people/{id}")
    suspend fun getPeople(@Path("id") id: String): People

    @GET("planets/{id}")
    suspend fun getPlanet(@Path("id") id: String): Planets

    @GET("species/{id}")
    suspend fun getSpecies(@Path("id") id: String): Species

    @GET("starships/{id}")
    suspend fun getStarship(@Path("id") id: String): Starships

    @GET("vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: String): Vehicles
}