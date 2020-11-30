package com.abc.swapiclient.framework.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
    val cargoCapacity: String? = null,
    val consumables: String? = null,
    val costInCredits: String? = null,
    val created: String? = null,
    val crew: String? = null,
    val edited: String? = null,
    val films: List<String>? = null,
    val length: String? = null,
    val manufacturer: String? = null,
    val maxSpeedInAtmosphere: String? = null,
    val model: String? = null,
    val name: String? = null,
    val passengers: String? = null,
    val pilots: List<String>? = null,
    val url: String? = null,
    val vehicleClass: String? = null,
    val imageURL: String? = null,
    @PrimaryKey
    val id: Int = 0
)