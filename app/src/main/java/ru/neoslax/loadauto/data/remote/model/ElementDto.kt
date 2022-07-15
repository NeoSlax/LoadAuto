package ru.neoslax.loadauto.data.remote.model


import com.google.gson.annotations.SerializedName

data class ElementDto(
    @SerializedName("group")
    val group: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("parent")
    val parent: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)