package com.abc.swapiclient.data.network.mapper


import com.abc.swapiclient.data.network.vo.People
import com.abc.swapiclient.data.util.EntityMapper
import javax.inject.Inject

class PeopleMapper
@Inject constructor() : EntityMapper<People, com.abc.swapiclient.domain.Person> {
    override fun mapFromEntity(entity: People): com.abc.swapiclient.domain.Person {
        return com.abc.swapiclient.domain.Person(
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
            imageURL = "https://starwars-visualguide.com/assets/img/characters/" + (entity.url
                ?: "").split("/").last(),
        )
    }

    override fun mapToEntity(domainModel: com.abc.swapiclient.domain.Person): People {
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
            vehicles = domainModel.vehicles)
    }

}