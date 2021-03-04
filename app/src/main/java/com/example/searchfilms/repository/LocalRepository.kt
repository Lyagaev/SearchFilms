package com.example.searchfilms.repository

import com.example.searchfilms.models.FilmNote

interface LocalRepository {
    fun getAllNote(): List<FilmNote>
    fun getNoteForMovie(id: Int): FilmNote
    fun saveEntity(filmNote: FilmNote)
    fun updateEntity(filmNote: FilmNote)
}