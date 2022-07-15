package ru.neoslax.loadauto.data.remote.model


import com.google.gson.annotations.SerializedName

data class DeviceResponseDto(
    @SerializedName("devices")
    val devices: DevicesDto
)