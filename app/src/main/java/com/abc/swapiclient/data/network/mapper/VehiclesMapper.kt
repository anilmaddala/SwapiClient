package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Vehicles
import com.abc.swapiclient.domain.models.Vehicle
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class VehiclesMapper @Inject constructor() : EntityMapper<Vehicles, Vehicle> {
    override fun mapFromEntity(entity: Vehicles): Vehicle {
        return Vehicle(cargoCapacity = entity.cargoCapacity,
            consumables = entity.consumables,
            costInCredits = entity.costInCredits,
            created = entity.created,
            crew = entity.crew,
            edited = entity.edited,
            films = entity.films,
            length = entity.length,
            manufacturer = entity.manufacturer,
            maxSpeedInAtmosphere = entity.maxAtmospheringSpeed,
            model = entity.model,
            name = entity.name,
            passengers = entity.passengers,
            pilots = entity.pilots,
            url = entity.url,
            vehicleClass = entity.vehicleClass,
            imageURL = getImageURL(entity.url ?: ""))
    }

    /**
     * Mapper for Planet Image URL
     * Sample URL: https://starwars-visualguide.com/assets/img/vehicles/7.jpg
     */
    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/vehicles/$id.jpg"
    }

    override fun mapToEntity(domainModel: Vehicle): Vehicles {
        TODO("Not yet implemented")
    }
}