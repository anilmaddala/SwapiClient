package com.abc.swapiclient.domain.models

data class PersonSearchResult(
    val next: String? = null,
    val previous: String? = null,
    val personList: List<Person>? = null
)