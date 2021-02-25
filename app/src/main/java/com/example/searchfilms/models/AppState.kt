package com.example.searchfilms.models

sealed class AppState {
    data class Success(val filmData: MovieList) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
