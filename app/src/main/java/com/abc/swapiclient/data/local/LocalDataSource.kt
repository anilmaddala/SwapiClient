package com.abc.swapiclient.data.local

import com.abc.swapiclient.domain.models.*

interface LocalDataSource {

    suspend fun getFilm(id: String): Film

    suspend fun getPerson(id: String): Person

    suspend fun getPlanet(id: String): Planet

    suspend fun getSpecies(id: String): Species

    suspend fun getStarship(id: String): Starship

    suspend fun getVehicle(id: String): Vehicle

    suspend fun addPerson(people: Person)

    suspend fun addPlanet(plane: Planet)

    suspend fun addSpecies(species: Species)

    suspend fun addStarship(starship: Starship)

    suspend fun addVehicle(vehicle: Vehicle)
}