package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Starships
import com.abc.swapiclient.domain.models.Starship
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class StarshipsMapper @Inject constructor() : EntityMapper<Starships, Starship> {
    override fun mapFromEntity(entity: Starships): Starship {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: Starship): Starships {
        TODO("Not yet implemented")
    }

}