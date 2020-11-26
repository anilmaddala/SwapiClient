package com.abc.swapiclient.data.network.vo


import com.google.gson.annotations.SerializedName

data class Species(
    @SerializedName("average_height")
    val averageHeight: String? = null,
    @SerializedName("average_lifespan")
    val averageLifespan: String? = null,
    @SerializedName("classification")
    val classification: String? = null,
    @SerializedName("created")
    val created: String? = null,
    @SerializedName("designation")
    val designation: String? = null,
    @SerializedName("edited")
    val edited: String? = null,
    @SerializedName("eye_colors")
    val eyeColors: String? = null,
    @SerializedName("films")
    val films: List<String>? = null,
    @SerializedName("hair_colors")
    val hairColors: String? = null,
    @SerializedName("homeworld")
    val homeworld: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("people")
    val people: List<String>? = null,
    @SerializedName("skin_colors")
    val skinColors: String? = null,
    @SerializedName("url")
    val url: String? = null
)