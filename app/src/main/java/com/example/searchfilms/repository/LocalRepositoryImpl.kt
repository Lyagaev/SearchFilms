package com.example.searchfilms.repository

import com.example.searchfilms.models.FilmNote
import com.example.searchfilms.models.room.NoteDao
import com.example.searchfilms.models.room.NoteEntity

class LocalRepositoryImpl(private val localDataSource: NoteDao) :
        LocalRepository {

    override fun getNoteForMovie(idMovie: Int): FilmNote {
        localDataSource.getDataByMove(idMovie)?.let{
            return convertHistoryEntityToNote(it)
        }
        return FilmNote()
    }

    override fun getAllNote(): List<FilmNote> {
        return convertHistoryEntityToNoteList(localDataSource.all())
    }

    override fun saveEntity(filmNote: FilmNote) {
        localDataSource.insert(convertWeatherToEntity(filmNote))
    }

    override fun updateEntity(filmNote: FilmNote) {
        localDataSource.update(convertWeatherToEntity(filmNote))
    }

    private fun convertHistoryEntityToNoteList(entityList: List<NoteEntity>): List<FilmNote> {
        return entityList.map {
            FilmNote(it.id_move, it.note)
        }
    }

    private fun convertHistoryEntityToNote(entity: NoteEntity): FilmNote {
        return FilmNote(entity.id_move, entity.note)
    }

    private fun convertWeatherToEntity(filmNote: FilmNote): NoteEntity {
        return NoteEntity(0, filmNote.id_move, filmNote.note)
    }
}