package ru.neoslax.loadauto.domain.entity

data class DeviceEntity(
    val entityType: EntityType,
    val title: String,
    val lat: Double?,
    val lon: Double?
)

enum class EntityType {
    GROUP, CAR
}