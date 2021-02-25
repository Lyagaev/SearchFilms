package com.example.searchfilms.repository

import com.example.searchfilms.models.Film
import com.example.searchfilms.models.MAIN_LINK
import com.example.searchfilms.models.MOVIE_API_KEY
import com.example.searchfilms.models.MovieList
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RemoteDataSourceMovie {
    private val movieApi = Retrofit.Builder()
            .baseUrl(MAIN_LINK)
            .addConverterFactory(
                    GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                    )
            )
            .build().create(MovieAPI::class.java)

    fun getPopularMovieList(callback: Callback<MovieList>) {
        movieApi.getTrending(MOVIE_API_KEY).enqueue(callback)
    }

    fun getNewMovieList(callback: Callback<MovieList>,
                        sortBy:String,
                        includeAdult: Boolean,
                        include_video: Boolean,
                        page: Int
                        ) {
        movieApi.getNewMovie(MOVIE_API_KEY,
                sortBy,
                includeAdult,
                include_video,
                page,
                ).enqueue(callback)
    }
}
