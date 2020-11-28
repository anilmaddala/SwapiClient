package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Species
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class SpeciesMapper @Inject constructor() :
    EntityMapper<Species, com.abc.swapiclient.domain.models.Species> {
    override fun mapFromEntity(entity: Species): com.abc.swapiclient.domain.models.Species {
        return com.abc.swapiclient.domain.models.Species(averageHeight = entity.averageHeight,
            averageLifespan = entity.averageLifespan,
            classification = entity.classification,
            created = entity.created,
            designation = entity.designation,
            edited = entity.edited,
            eyeColors = entity.eyeColors,
            films = entity.films,
            hairColors = entity.hairColors,
            homeworld = entity.homeworld,
            language = entity.language,
            name = entity.name,
            people = entity.people,
            skinColors = entity.skinColors,
            imageURL = getImageURL(entity.url ?: ""),
            url = entity.url)
    }

    /**
     * Mapper for Planet Image URL
     * Sample URL: https://starwars-visualguide.com/assets/img/species/1.jpg
     */
    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/species/$id.jpg"
    }

    override fun mapToEntity(domainModel: com.abc.swapiclient.domain.models.Species): Species {
        TODO("Not yet implemented")
    }
}