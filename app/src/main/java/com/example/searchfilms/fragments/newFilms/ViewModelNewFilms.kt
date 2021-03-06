package com.example.searchfilms.fragments.newFilms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.Film

class ViewModelNewFilms (private val liveDataToObserve: MutableLiveData<MutableList<Film>> =
                                   MutableLiveData()): ViewModel() {


    fun getData(): LiveData<MutableList<Film>> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    private fun generateDataFromLocalSource() {
        Thread {
            var myList: MutableList<Film> = mutableListOf<Film>()
            myList.add(Film("Боевик 1", 5.0))
            myList.add(Film("Комедия 2", 6.0))
            myList.add(Film("Драма 3", 7.0))
            liveDataToObserve.postValue(myList)
        }.start()
    }


}