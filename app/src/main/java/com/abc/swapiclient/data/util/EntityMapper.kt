package com.abc.swapiclient.data.util

/**
 * Mapper used to convert between Entity <-> Domain Model
 */
interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}