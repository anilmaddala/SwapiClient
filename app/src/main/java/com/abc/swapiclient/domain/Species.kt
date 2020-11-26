package com.abc.swapiclient.domain

data class Species(
    val averageHeight: String? = null,
    val averageLifespan: String? = null,
    val classification: String? = null,
    val created: String? = null,
    val designation: String? = null,
    val edited: String? = null,
    val eyeColors: String? = null,
    val films: List<String>? = null,
    val hairColors: String? = null,
    val homeworld: String? = null,
    val language: String? = null,
    val name: String? = null,
    val people: List<String>? = null,
    val skinColors: String? = null,
    val imageURL: String? = null,
    val url: String? = null,
    val id: Int = 0
)