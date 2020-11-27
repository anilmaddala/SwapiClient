package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Species
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class SpeciesMapper @Inject constructor() :
    EntityMapper<Species, com.abc.swapiclient.domain.models.Species> {
    override fun mapFromEntity(entity: Species): com.abc.swapiclient.domain.models.Species {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: com.abc.swapiclient.domain.models.Species): Species {
        TODO("Not yet implemented")
    }
}