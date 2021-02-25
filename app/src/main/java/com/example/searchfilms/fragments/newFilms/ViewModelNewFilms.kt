package com.example.searchfilms.fragments.newFilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.models.*
import com.example.searchfilms.repository.DetailsRepository
import com.example.searchfilms.repository.DetailsRepositoryImpl
import com.example.searchfilms.repository.RemoteDataSourceMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNewFilms (
        private val newMovieLiveData: MutableLiveData<AppState> = MutableLiveData(),
        private val detailsRepositoryImpl: DetailsRepository = DetailsRepositoryImpl(RemoteDataSourceMovie())
): ViewModel() {

    fun getNewMovieLiveData() = newMovieLiveData

    fun getNewMovieFromRemoteSource() {
        newMovieLiveData.value = AppState.Loading
        detailsRepositoryImpl.getNewMovieListFromServer(callBack, "primary_release_date.desc", includeAdult = false, include_video = false, page = 1)
    }

    private val callBack = object :
            Callback<MovieList> {

        override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
            val serverResponse: MovieList? = response.body()
            newMovieLiveData.postValue(
                    if (response.isSuccessful && serverResponse != null) {
                        getCheckedResponse(serverResponse)
                    } else {
                        AppState.Error(Throwable(SERVER_ERROR))
                    }
            )
        }

        override fun onFailure(call: Call<MovieList>, t: Throwable) {
            newMovieLiveData.postValue(AppState.Error(Throwable(t.message ?: REQUEST_ERROR)))
        }

        @Suppress("NullChecksToSafeCall")
        private fun getCheckedResponse(serverResponse: MovieList): AppState {
            return if (serverResponse == null) {
                AppState.Error(Throwable(CORRUPTED_DATA))
            } else {
                AppState.Success(serverResponse)
            }
        }
    }

}