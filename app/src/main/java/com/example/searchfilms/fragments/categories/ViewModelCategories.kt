package com.example.searchfilms.fragments.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelCategories (private val liveDataToObserve: MutableLiveData<MutableList<String>> =
                                   MutableLiveData()): ViewModel() {


    fun getData(): LiveData<MutableList<String>> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    private fun generateDataFromLocalSource() {
        Thread {
            var myList: MutableList<String> = mutableListOf<String>()
            myList.add("Комедии")
            myList.add("Боевики")
            liveDataToObserve.postValue(myList)
        }.start()
    }

}