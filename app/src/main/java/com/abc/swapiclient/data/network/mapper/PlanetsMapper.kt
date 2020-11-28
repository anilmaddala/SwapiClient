package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Planets
import com.abc.swapiclient.domain.models.Planet
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class PlanetsMapper @Inject constructor() : EntityMapper<Planets, Planet> {
    override fun mapFromEntity(entity: Planets): Planet {
        return Planet(
            climate = entity.climate,
            created = entity.created,
            diameter = entity.diameter,
            edited = entity.edited,
            films = entity.films,
            gravity = entity.gravity,
            name = entity.name,
            orbitalPeriod = entity.orbitalPeriod,
            population = entity.population,
            residents = entity.residents,
            rotationPeriod = entity.rotationPeriod,
            surfaceWater = entity.surfaceWater,
            terrain = entity.terrain,
            imageURL = getImageURL(entity.url ?: ""),
            url = entity.url
        )
    }

    /**
     * Mapper for Planet Image URL
     * Sample URL: https://starwars-visualguide.com/assets/img/planets/2.jpg
     */
    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/planets/$id.jpg"
    }

    override fun mapToEntity(domainModel: Planet): Planets {
        TODO("Not yet implemented")
    }
}