package com.example.moviesmate.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryMoviesDto(
    @SerializedName("page")
    val pagingPageDto: Int,
    val results: List<ResultDto>,
    val total_pages: Int,
    val total_results: Int
) {
    data class ResultDto(
        val adult: Boolean,
        val backdrop_path: String?,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    )
}