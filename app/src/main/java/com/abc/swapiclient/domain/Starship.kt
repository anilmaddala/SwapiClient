package com.abc.swapiclient.domain

data class Starship(
    val cargoCapacity: String? = null,
    val consumables: String? = null,
    val costInCredits: String? = null,
    val created: String? = null,
    val crew: String? = null,
    val edited: String? = null,
    val films: List<String>? = null,
    val hyperdriveRating: String? = null,
    val length: String? = null,
    val maxMGLT: String? = null,
    val manufacturer: String? = null,
    val maxAtmospheringSpeed: String? = null,
    val model: String? = null,
    val name: String? = null,
    val passengers: String? = null,
    val pilots: List<String>? = null,
    val starshipClass: String? = null,
    val imageURL: String? = null,
    val url: String? = null,
    val id: Int = 0
)