package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.PeopleSearchResponse
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.models.PersonSearchResult
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class SearchResponseMapper @Inject constructor() :
    EntityMapper<PeopleSearchResponse, PersonSearchResult> {

    override fun mapFromEntity(entity: PeopleSearchResponse): PersonSearchResult {
        val listOfPerson = ArrayList<Person>()
        entity.results?.forEach {
            listOfPerson.add(PeopleMapper().mapFromEntity(it))
        }
        return PersonSearchResult(
            next = entity.next,
            previous = entity.previous,
            personList = listOfPerson
        )
    }

    override fun mapToEntity(domainModel: PersonSearchResult): PeopleSearchResponse {
        TODO("Not yet implemented")
    }
}