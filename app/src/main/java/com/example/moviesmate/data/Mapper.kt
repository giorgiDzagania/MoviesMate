package com.example.moviesmate.data

import com.example.moviesmate.data.remote.dto.AboutActorDto
import com.example.moviesmate.data.remote.dto.ActorDetailsDto
import com.example.moviesmate.data.remote.dto.ActorFilmographyDto
import com.example.moviesmate.data.remote.dto.CategoryMoviesDto
import com.example.moviesmate.data.remote.dto.GenresTypeDto
import com.example.moviesmate.data.remote.dto.MovieDetailsDto
import com.example.moviesmate.data.remote.dto.SearchInputDto
import com.example.moviesmate.data.remote.dto.HomePageMoviesDto
import com.example.moviesmate.data.remote.dto.YoutubeDto
import com.example.moviesmate.domain.model.AboutActor
import com.example.moviesmate.domain.model.ActorDetails
import com.example.moviesmate.domain.model.ActorFilmography
import com.example.moviesmate.domain.model.CategoryMovies
import com.example.moviesmate.domain.model.GenresType
import com.example.moviesmate.domain.model.MovieDetails
import com.example.moviesmate.domain.model.SearchInput
import com.example.moviesmate.domain.model.HomePageMovies
import com.example.moviesmate.domain.model.Youtube

//Dto -> domain
fun GenresTypeDto.toGenresType(): GenresType {
    return GenresType(
        genres = this.genres.map { genreDto ->
            GenresType.Genre(
                id = genreDto.id,
                name = genreDto.name
            )
        }
    )
}

// dto to domain
fun CategoryMoviesDto.toCategoryMovies(): CategoryMovies {
    return CategoryMovies(
        pagingPage = this.pagingPageDto,
        results = this.results.map { resultDto ->
            CategoryMovies.Result(
                adult = resultDto.adult,
                backdrop_path = resultDto.backdrop_path,
                genre_ids = resultDto.genre_ids,
                id = resultDto.id,
                original_language = resultDto.original_language,
                original_title = resultDto.original_title,
                overview = resultDto.overview,
                popularity = resultDto.popularity,
                poster_path = resultDto.poster_path,
                release_date = resultDto.release_date,
                title = resultDto.title,
                video = resultDto.video,
                vote_average = resultDto.vote_average,
                vote_count = resultDto.vote_count
            )
        },
        total_pages = this.total_pages,
        total_results = this.total_results
    )
}

// dto to domain
fun SearchInputDto.toSearchInput(): SearchInput {
    return SearchInput(
        page = this.page,
        results = this.results.map { resultDto ->
            SearchInput.SearchedMovie(
                adult = resultDto.adult,
                backdrop_path = resultDto.backdrop_path,
                genre_ids = resultDto.genre_ids,
                id = resultDto.id,
                original_language = resultDto.original_language,
                original_title = resultDto.original_title,
                overview = resultDto.overview,
                popularity = resultDto.popularity,
                poster_path = resultDto.poster_path,
                release_date = resultDto.release_date,
                title = resultDto.title,
                video = resultDto.video,
                vote_average = resultDto.vote_average,
                vote_count = resultDto.vote_count
            )
        },
        total_pages = this.total_pages,
        total_results = this.total_results
    )
}

fun MovieDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        backdrop_path = this.backdrop_path,
        genres = this.genres?.map { MovieDetails.Genre(it.id, it.name) },
        id = this.id,
        original_title = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.poster_path,
        runtime = this.runtime,
        title = this.title,
        vote_average = this.vote_average,
        release_date = this.release_date
    )
}

fun ActorDetailsDto.toActorDetails(): ActorDetails {
    return ActorDetails(
        id = this.id,
        cast = this.cast?.map { castDto ->
            ActorDetails.Cast(
                cast_id = castDto.cast_id,
                credit_id = castDto.credit_id,
                id = castDto.id,
                original_name = castDto.original_name,
                profile_path = castDto.profile_path
            )
        }
    )
}

fun AboutActorDto.toAboutActor(): AboutActor {
    return AboutActor(
        biography = this.biography,
        birthday = this.birthday,
        deathday = this.deathday,
        homepage = this.homepage,
        id = this.id,
        name = this.name,
        place_of_birth = this.place_of_birth,
        popularity = this.popularity,
        profile_path = this.profile_path
    )
}


fun ActorFilmographyDto.toActorFilmography(): ActorFilmography {
    return ActorFilmography(
        cast = this.cast?.map { ActorFilmography.Cast(it.id, it.poster_path) },
        id = this.id
    )
}

fun HomePageMoviesDto.toHomePageMovies(): HomePageMovies {
    return HomePageMovies(
        page = this.page,
        results = this.results?.map { movieDto ->
            HomePageMovies.Movie(
                id = movieDto.id,
                backdrop_path = movieDto.backdrop_path,
                poster_path = movieDto.poster_path,
                title = movieDto.title
            )
        }
    )
}


fun YoutubeDto.toYoutube(): Youtube {
    return Youtube(
        id = this.id,
        results = this.results.map { videoDto ->
            Youtube.Video(
                iso_639_1 = videoDto?.iso_639_1,
                iso_3166_1 = videoDto?.iso_3166_1,
                name = videoDto?.name,
                key = videoDto?.key,
                site = videoDto?.site,
                size = videoDto?.size,
                type = videoDto?.type,
                official = videoDto?.official,
                published_at = videoDto?.published_at,
                id = videoDto?.id
            )
        } ?: emptyList()
    )
}