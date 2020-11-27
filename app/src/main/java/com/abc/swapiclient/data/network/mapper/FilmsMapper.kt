package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Films
import com.abc.swapiclient.domain.models.Film
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class FilmsMapper @Inject constructor() : EntityMapper<Films, Film> {
    override fun mapFromEntity(entity: Films): Film {
        return Film(
            characters = entity.characters,
            created = entity.created,
            director = entity.director,
            edited = entity.edited,
            episodeId = entity.episodeId,
            openingCrawl = entity.openingCrawl,
            planets = entity.planets,
            producer = entity.producer,
            releaseDate = entity.releaseDate,
            species = entity.species,
            starships = entity.starships,
            title = entity.title,
            vehicles = entity.vehicles,
            imageURL = getImageURL(entity.url ?: ""),
            url = entity.url
        )
    }

    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/films/$id.jpg"
    }

    override fun mapToEntity(domainModel: Film): Films {
        return Films(
            characters = domainModel.characters,
            created = domainModel.created,
            director = domainModel.director,
            edited = domainModel.edited,
            episodeId = domainModel.episodeId,
            openingCrawl = domainModel.openingCrawl,
            planets = domainModel.planets,
            producer = domainModel.producer,
            releaseDate = domainModel.releaseDate,
            species = domainModel.species,
            starships = domainModel.starships,
            title = domainModel.title,
            url = domainModel.url,
            vehicles = domainModel.vehicles
        )
    }
}