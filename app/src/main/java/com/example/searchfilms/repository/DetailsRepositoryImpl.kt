package com.example.searchfilms.repository

import com.example.searchfilms.models.MovieList
import retrofit2.Callback

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSourceMovie) :
        DetailsRepository {

    override fun getPopularMovieListFromServer(callback: Callback<MovieList>) {
        remoteDataSource.getPopularMovieList(callback)
    }

    override fun getNewMovieListFromServer(callback: Callback<MovieList>,
                                           sortBy:String,
                                           includeAdult: Boolean,
                                           include_video: Boolean,
                                           page: Int
    ) {
        remoteDataSource.getNewMovieList(callback,
                sortBy,
                includeAdult,
                include_video,
                page)
    }
}

