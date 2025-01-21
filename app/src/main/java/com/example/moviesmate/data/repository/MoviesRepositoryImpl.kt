package com.example.moviesmate.data.repository

import com.example.moviesmate.core.ApiCallHelper
import com.example.moviesmate.core.OperationStatus
import com.example.moviesmate.core.map
import com.example.moviesmate.data.remote.service.MovieService
import com.example.moviesmate.data.toGenresType
import com.example.moviesmate.domain.model.GenresType
import com.example.moviesmate.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val service: MovieService
) : MoviesRepository {

    override suspend fun getGenresTypes(): OperationStatus<GenresType> {
        return ApiCallHelper.safeApiCall {
            service.getGenresType()
        }.map { genresTypeDto -> genresTypeDto.toGenresType() }
    }

}