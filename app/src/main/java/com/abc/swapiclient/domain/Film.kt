package com.abc.swapiclient.domain

data class Film(
    val characters: List<String>? = null,
    val created: String? = null,
    val director: String? = null,
    val edited: String? = null,
    val episodeId: Int? = null,
    val openingCrawl: String? = null,
    val planets: List<String>? = null,
    val producer: String? = null,
    val releaseDate: String? = null,
    val species: List<String>? = null,
    val starships: List<String>? = null,
    val title: String? = null,
    val vehicles: List<String>? = null,
    val imageURL: String? = null,
    val url: String? = null,
    val id: Int = 0
)