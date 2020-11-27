package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.PeopleSearchResponse
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class SearchResponseMapper @Inject constructor() :
    EntityMapper<PeopleSearchResponse, List<Person>> {
    override fun mapFromEntity(entity: PeopleSearchResponse): List<Person> {
        val res = ArrayList<Person>()
        entity.results?.forEach {
            res.add(PeopleMapper().mapFromEntity(it))
        }
        return res
    }

    override fun mapToEntity(domainModel: List<Person>): PeopleSearchResponse {
        TODO("Not yet implemented")
    }
}