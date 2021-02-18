package com.example.searchfilms.fragments.newFilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.models.AppState
import com.example.searchfilms.models.Film

class ViewModelNewFilms (private val liveDataToObserve: MutableLiveData<AppState> =
                                   MutableLiveData()): ViewModel() {

    fun getGenerateDataFromLocalSource() = generateDataFromLocalSource()

    fun getData(): LiveData<AppState> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    private fun generateDataFromLocalSource() {
        Thread {
            var myList: MutableList<Film> = mutableListOf<Film>()
            myList.add(Film("Боевик 1", 5.0))
            myList.add(Film("Комедия 2", 6.0))
            myList.add(Film("Драма 3", 7.0))
            liveDataToObserve.postValue(AppState.Success(myList))
        }.start()
    }

}