package com.abc.swapiclient.framework.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    val birthYear: String? = null,
    val created: String? = null,
    val edited: String? = null,
    val eyeColor: String? = null,
    val films: List<String>? = null,
    val gender: String? = null,
    val hairColor: String? = null,
    val height: String? = null,
    val homeworld: String? = null,
    val mass: String? = null,
    val name: String? = null,
    val skinColor: String? = null,
    val species: List<String>? = null,
    val starships: List<String>? = null,
    val vehicles: List<String>? = null,
    val imageURL: String? = null,
    val url: String? = null,
    @PrimaryKey
    val id: Int = 0
)