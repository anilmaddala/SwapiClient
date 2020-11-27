package com.abc.swapiclient.data.network.vo


import com.google.gson.annotations.SerializedName

data class PeopleSearchResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<People>? = null
)