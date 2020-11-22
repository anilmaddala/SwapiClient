package com.abc.data.util

/**
 * Mapper used to convert between Entity <-> Domain Model
 */
interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}