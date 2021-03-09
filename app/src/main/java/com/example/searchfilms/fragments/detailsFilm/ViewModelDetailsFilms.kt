package com.example.searchfilms.fragments.detailsFilm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchfilms.app.App.Companion.getNoteDao
import com.example.searchfilms.models.Film
import com.example.searchfilms.models.FilmNote
import com.example.searchfilms.repository.LocalRepository
import com.example.searchfilms.repository.LocalRepositoryImpl

class ViewModelDetailsFilms (private val liveDataToObserve: MutableLiveData<Film> =
                                   MutableLiveData(),
                             private val NoteRepository: LocalRepository = LocalRepositoryImpl(getNoteDao())
): ViewModel() {


    fun getData(): LiveData<Film> {
        generateDataFromLocalSource()
        return liveDataToObserve
    }

    fun getNote(id : Int) : String{
        return NoteRepository.getNoteForMovie(id).note.toString()
    }

    fun getNoteAll() : List<FilmNote>{
        return NoteRepository.getAllNote()
    }

    private fun generateDataFromLocalSource() {
        Thread {
            //liveDataToObserve.postValue(Film("Боевик 1", 5.0,""))
        }.start()
    }

    fun saveNoteToDB(filmNote: FilmNote) {
        NoteRepository.saveEntity(filmNote)
    }

    fun updateNoteToDB(filmNote: FilmNote) {
        NoteRepository.updateEntity(filmNote)
    }
}