package com.abc.swapiclient.data.network.vo


import com.google.gson.annotations.SerializedName

data class Starships(
    @SerializedName("cargo_capacity")
    val cargoCapacity: String? = null,
    @SerializedName("consumables")
    val consumables: String? = null,
    @SerializedName("cost_in_credits")
    val costInCredits: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("crew")
    val crew: String? = null,
    @SerializedName("edited")
    val edited: String? = null,
    @SerializedName("films")
    val films: List<String>? = null,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String? = null,
    @SerializedName("length")
    val length: String? = null,
    @SerializedName("MGLT")
    val mGLT: String? = null,
    @SerializedName("manufacturer")
    val manufacturer: String? = null,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("passengers")
    val passengers: String? = null,
    @SerializedName("pilots")
    val pilots: List<String>? = null,
    @SerializedName("starship_class")
    val starshipClass: String? = null,
    @SerializedName("url")
    val url: String? = null
)