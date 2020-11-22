package com.abc.data.network.vo


import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("birth_year")
    val birthYear: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("edited")
    val edited: String? = null,
    @SerializedName("eye_color")
    val eyeColor: String? = null,
    @SerializedName("films")
    val films: List<String>? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("hair_color")
    val hairColor: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("homeworld")
    val homeworld: String? = null,
    @SerializedName("mass")
    val mass: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("skin_color")
    val skinColor: String? = null,
    @SerializedName("species")
    val species: List<String>? = null,
    @SerializedName("starships")
    val starships: List<String>? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("vehicles")
    val vehicles: List<String>? = null
)