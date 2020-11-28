package com.abc.swapiclient.data.network.mapper


import com.abc.swapiclient.data.network.vo.People
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class PeopleMapper
@Inject constructor() : EntityMapper<People, Person> {
    override fun mapFromEntity(entity: People): Person {
        return Person(
            birthYear = entity.birthYear,
            created = entity.created,
            edited = entity.edited,
            eyeColor = entity.eyeColor,
            films = entity.films,
            gender = entity.gender,
            hairColor = entity.hairColor,
            height = entity.height,
            homeworld = entity.homeworld,
            mass = entity.mass,
            name = entity.name,
            skinColor = entity.skinColor,
            species = entity.species,
            starships = entity.starships,
            vehicles = entity.vehicles,
            url = entity.url,
            imageURL = getImageURL(entity.url ?: ""),
            id = getId(entity.url ?: "")
        )
    }

    /**
     * Mapper for Person Id
     * Sample URL: https://starwars-visualguide.com/assets/img/characters/2.jpg
     */
    private fun getId(url: String): Int {
        if (url.isEmpty()) {
            return 0
        }
        val splitList = url.split("/")
        return Integer.valueOf(splitList[splitList.lastIndex - 1])
    }

    /**
     * Mapper for People Image URL
     * Sample URL: https://starwars-visualguide.com/assets/img/characters/2.jpg
     */
    private fun getImageURL(url: String): String {
        if (url.isEmpty()) {
            return ""
        }
        val splitList = url.split("/")
        val id = splitList[splitList.lastIndex - 1]
        return "https://starwars-visualguide.com/assets/img/characters/$id.jpg"
    }

    override fun mapToEntity(domainModel: Person): People {
        return People(
            birthYear = domainModel.birthYear,
            created = domainModel.created,
            edited = domainModel.edited,
            eyeColor = domainModel.eyeColor,
            films = domainModel.films,
            gender = domainModel.gender,
            hairColor = domainModel.hairColor,
            height = domainModel.height,
            homeworld = domainModel.homeworld,
            mass = domainModel.mass,
            name = domainModel.name,
            skinColor = domainModel.skinColor,
            species = domainModel.species,
            starships = domainModel.starships,
            url = domainModel.url,
            vehicles = domainModel.vehicles
        )
    }

}