package com.android.movieapp.data.model


import com.google.gson.annotations.SerializedName

data class MoviePageData(
    @SerializedName("results")
    val movies: List<MovieData> = listOf(),
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
): BaseData()