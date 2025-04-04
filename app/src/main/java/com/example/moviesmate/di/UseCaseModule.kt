package com.example.moviesmate.di

import com.example.moviesmate.domain.usecases.AboutActorDetailsInfoUseCase
import com.example.moviesmate.domain.usecases.ActorDetailsUseCase
import com.example.moviesmate.domain.usecases.ActorFilmographyUseCase
import com.example.moviesmate.domain.usecases.DeleteFromFavoritesUsaCase
import com.example.moviesmate.domain.usecases.FetchGenresTypesUseCase
import com.example.moviesmate.domain.usecases.FetchMoviesByGenreUseCase
import com.example.moviesmate.domain.usecases.GetAllFavoritesUseCase
import com.example.moviesmate.domain.usecases.GetUserEmailUseCase
import com.example.moviesmate.domain.usecases.GetUserNameUseCase
import com.example.moviesmate.domain.usecases.GetUserProfileImageUseCase
import com.example.moviesmate.domain.usecases.LogOutUseCase
import com.example.moviesmate.domain.usecases.LoginUserUseCase
import com.example.moviesmate.domain.usecases.MovieDetailsUseCase
import com.example.moviesmate.domain.usecases.PasswordResetUseCase
import com.example.moviesmate.domain.usecases.PopularMoviesUseCase
import com.example.moviesmate.domain.usecases.RegisterNewUserUseCase
import com.example.moviesmate.domain.usecases.SaveToFavoriteUseCase
import com.example.moviesmate.domain.usecases.SearchMovieInputUseCase
import com.example.moviesmate.domain.usecases.UpcomingMoviesUseCase
import com.example.moviesmate.domain.usecases.UpdateUserNameUseCase
import com.example.moviesmate.domain.usecases.UploadImageToFireStoreUseCase
import com.example.moviesmate.domain.usecases.YoutubeVideoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { RegisterNewUserUseCase(get()) }
    factory { LoginUserUseCase(get()) }
    factory { PasswordResetUseCase(get()) }
    factory { FetchGenresTypesUseCase(get()) }
    factory { FetchMoviesByGenreUseCase(get()) }
    factory { SearchMovieInputUseCase(get()) }
    factory { MovieDetailsUseCase(get()) }
    factory { ActorDetailsUseCase(get()) }
    factory { AboutActorDetailsInfoUseCase(get()) }
    factory { ActorFilmographyUseCase(get()) }
    factory { SaveToFavoriteUseCase(get()) }
    factory { GetAllFavoritesUseCase(get()) }
    factory { DeleteFromFavoritesUsaCase(get()) }
    factory { UpcomingMoviesUseCase(get()) }
    factory { PopularMoviesUseCase(get()) }
    factory { GetUserNameUseCase(get()) }
    factory { GetUserEmailUseCase(get()) }
    factory { UpdateUserNameUseCase(get()) }
    factory { LogOutUseCase(get()) }
    factory { YoutubeVideoUseCase(get()) }
    factory { UploadImageToFireStoreUseCase(get()) }
    factory { GetUserProfileImageUseCase(get()) }
}