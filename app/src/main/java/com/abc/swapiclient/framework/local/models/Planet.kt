package com.abc.swapiclient.framework.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Planet(
    val climate: String? = null,
    val created: String? = null,
    val diameter: String? = null,
    val edited: String? = null,
    val films: List<String>? = null,
    val gravity: String? = null,
    val name: String? = null,
    val orbitalPeriod: String? = null,
    val population: String? = null,
    val residents: List<String>? = null,
    val rotationPeriod: String? = null,
    val surfaceWater: String? = null,
    val terrain: String? = null,
    val imageURL: String? = null,
    val url: String? = null,
    @PrimaryKey
    val id: Int = 0
)