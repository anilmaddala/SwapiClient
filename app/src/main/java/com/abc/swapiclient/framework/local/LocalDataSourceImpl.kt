package com.abc.swapiclient.framework.local

import com.abc.swapiclient.data.local.LocalDataSource
import com.abc.swapiclient.domain.models.*

class LocalDataSourceImpl : LocalDataSource {
    override suspend fun getFilm(id: String): Film {
        TODO("Not yet implemented")
    }

    override suspend fun getPerson(id: String): Person {
        TODO("Not yet implemented")
    }

    override suspend fun getPlanet(id: String): Planet {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecies(id: String): Species {
        TODO("Not yet implemented")
    }

    override suspend fun getStarship(id: String): Starship {
        TODO("Not yet implemented")
    }

    override suspend fun getVehicle(id: String): Vehicle {
        TODO("Not yet implemented")
    }

    override suspend fun addPerson(people: Person) {
        TODO("Not yet implemented")
    }

    override suspend fun addPlanet(plane: Planet) {
        TODO("Not yet implemented")
    }

    override suspend fun addSpecies(species: Species) {
        TODO("Not yet implemented")
    }

    override suspend fun addStarship(starship: Starship) {
        TODO("Not yet implemented")
    }

    override suspend fun addVehicle(vehicle: Vehicle) {
        TODO("Not yet implemented")
    }

}