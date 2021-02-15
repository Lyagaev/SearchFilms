package com.example.searchfilms.fragments.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.models.Film

class ViewModelPopular (private val liveDataToObserve: MutableLiveData<MutableList<Film>> =
                                   MutableLiveData()): ViewModel() {


    fun getData(): LiveData<MutableList<Film>> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    private fun generateDataFromLocalSource() {
        Thread {
            var myList: MutableList<Film> = mutableListOf<Film>()
            myList.add(Film("Комедия 1", 5.0))
            myList.add(Film("Комедия 2", 6.0))
            myList.add(Film("Комедия 3", 7.0))
            liveDataToObserve.postValue(myList)
        }.start()
    }


}