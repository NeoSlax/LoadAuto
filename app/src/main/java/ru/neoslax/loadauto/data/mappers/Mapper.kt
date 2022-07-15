package ru.neoslax.loadauto.data.mappers

import ru.neoslax.loadauto.data.remote.model.DeviceResponseDto
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.entity.EntityType

fun DeviceResponseDto.toEntityList(): List<DeviceEntity> {
    val result = mutableListOf<DeviceEntity>()
    val elementListDto = this.devices.list
    for (dtoElement in elementListDto) {
        when (dtoElement.parent) {
            "root" -> result.add(
                DeviceEntity(
                    entityType = EntityType.GROUP,
                    title = dtoElement.title, lat = null, lon = null
                )
            )
            else -> result.add(
                DeviceEntity(
                    entityType = EntityType.CAR,
                    title = dtoElement.title, lat = dtoElement.lat, lon = dtoElement.lon
                )
            )
        }
    }
    return result
}