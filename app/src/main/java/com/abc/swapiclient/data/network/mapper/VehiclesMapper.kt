package com.abc.swapiclient.data.network.mapper

import com.abc.swapiclient.data.network.vo.Vehicles
import com.abc.swapiclient.domain.models.Vehicle
import com.abc.swapiclient.domain.util.EntityMapper
import javax.inject.Inject

class VehiclesMapper @Inject constructor() : EntityMapper<Vehicles, Vehicle> {
    override fun mapFromEntity(entity: Vehicles): Vehicle {
        TODO("Not yet implemented")
    }

    override fun mapToEntity(domainModel: Vehicle): Vehicles {
        TODO("Not yet implemented")
    }
}