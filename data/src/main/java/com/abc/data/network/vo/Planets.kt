package com.abc.data.network.vo


import com.google.gson.annotations.SerializedName

data class Planets(
    @SerializedName("climate")
    val climate: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("diameter")
    val diameter: String? = null,
    @SerializedName("edited")
    val edited: String? = null,
    @SerializedName("films")
    val films: List<String>? = null,
    @SerializedName("gravity")
    val gravity: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("orbital_period")
    val orbitalPeriod: String? = null,
    @SerializedName("population")
    val population: String? = null,
    @SerializedName("residents")
    val residents: List<String>? = null,
    @SerializedName("rotation_period")
    val rotationPeriod: String? = null,
    @SerializedName("surface_water")
    val surfaceWater: String? = null,
    @SerializedName("terrain")
    val terrain: String? = null,
    @SerializedName("url")
    val url: String? = null
)