package com.example.searchfilms.repository

import com.example.searchfilms.models.Film
import com.example.searchfilms.models.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieAPI {
    @GET("trending/movie/week")
    fun getTrending(
            @Query("api_key") token: String
    ): Call<MovieList>

    @GET("discover/movie")
    fun getNewMovie(
            @Query("api_key") token: String,
            @Query("sort_by") sortBy: String ,
            @Query("include_adult") includeAdult: Boolean,
            @Query("include_video") include_video: Boolean,
            @Query("page") page: Int
    ): Call<MovieList>
}
