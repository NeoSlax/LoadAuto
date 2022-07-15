package ru.neoslax.loadauto.data.remote.model


import com.google.gson.annotations.SerializedName

data class DevicesDto(
    @SerializedName("list")
    val list: List<ElementDto>
)