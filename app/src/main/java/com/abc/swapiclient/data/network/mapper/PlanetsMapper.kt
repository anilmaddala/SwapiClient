package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Planets
import com.abc.swapiclient.domain.models.Planet
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class PlanetsMapper @Inject constructor() : EntityMapper<Planets, Planet> {
    override fun mapFromEntity(entity: Planets): Planet {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: Planet): Planets {
        TODO("Not yet implemented")
    }
}