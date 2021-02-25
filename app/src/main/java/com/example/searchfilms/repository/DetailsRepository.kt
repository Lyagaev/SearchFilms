package com.example.searchfilms.repository

import com.example.searchfilms.models.Film
import com.example.searchfilms.models.MovieList

interface DetailsRepository {
    fun getPopularMovieListFromServer(
            callback: retrofit2.Callback<MovieList>
    )

    fun getNewMovieListFromServer(
            callback: retrofit2.Callback<MovieList>,
            sortBy:String,
            includeAdult: Boolean,
            include_video: Boolean,
            page: Int
    )
}
