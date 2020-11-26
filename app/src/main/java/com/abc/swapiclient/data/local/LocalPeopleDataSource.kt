package com.abc.swapiclient.data.local

import com.abc.swapiclient.domain.*

interface LocalPeopleDataSource {

    suspend fun getFilm(name: String)

    suspend fun getPerson(name: String)

    suspend fun getPlanet(name: String)

    suspend fun getSpecies(name: String)

    suspend fun getStarship(name: String)

    suspend fun getVehicle(name: String)

    suspend fun addPerson(people: Person)

    suspend fun addPlanet(plane: Planet)

    suspend fun addSpecies(species: Species)

    suspend fun addStarship(starship: Starship)

    suspend fun addVehicle(vehicle: Vehicle)
}