package com.example.searchfilms.fragments.detailsFilm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.models.Film

class ViewModelDetailsFilms (private val liveDataToObserve: MutableLiveData<Film> =
                                   MutableLiveData()): ViewModel() {


    fun getData(): LiveData<Film> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    private fun generateDataFromLocalSource() {
        Thread {
            liveDataToObserve.postValue(Film("Боевик 1", 5.0,""))
        }.start()
    }


}