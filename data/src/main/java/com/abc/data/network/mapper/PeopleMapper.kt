package com.abc.data.network.mapper

import com.abc.data.network.vo.People
import com.abc.data.util.EntityMapper
import javax.inject.Inject

class PeopleMapper
@Inject constructor() : EntityMapper<com.abc.data.network.vo.People, com.abc.domain.People> {
    override fun mapFromEntity(entity: People): com.abc.domain.People {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: com.abc.domain.People): People {
        TODO("Not yet implemented")
    }
}