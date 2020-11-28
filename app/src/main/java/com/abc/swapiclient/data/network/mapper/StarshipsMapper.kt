package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Starships
import com.abc.swapiclient.domain.models.Starship
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class StarshipsMapper @Inject constructor() : EntityMapper<Starships, Starship> {
    override fun mapFromEntity(entity: Starships): Starship {
        return Starship(cargoCapacity = entity.cargoCapacity,
            consumables = entity.consumables,
            costInCredits = entity.costInCredits,
            created = entity.created,
            crew = entity.crew,
            edited = entity.edited,
            films = entity.films,
            hyperdriveRating = entity.hyperdriveRating,
            length = entity.length,
            maxMGLT = entity.mGLT,
            manufacturer = entity.manufacturer,
            maxAtmospheringSpeed = entity.maxAtmospheringSpeed,
            model = entity.model,
            name = entity.name,
            passengers = entity.passengers,
            pilots = entity.pilots,
            starshipClass = entity.starshipClass,
            imageURL = getImageURL(entity.url ?: ""),
            url = entity.url)
    }

    /**
     * Mapper for Planet Image URL
     * Sample URL: https://starwars-visualguide.com/assets/img/starships/9.jpg
     */
    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/starships/$id.jpg"
    }

    override fun mapToEntity(domainModel: Starship): Starships {
        TODO("Not yet implemented")
    }

}