package com.example.searchfilms.models.room

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM NoteEntity")
    fun all(): List<NoteEntity>

    @Query("SELECT * FROM NoteEntity WHERE id_move LIKE :id_move")
    fun getDataByMove(id_move: Int): NoteEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: NoteEntity)

    @Update
    fun update(entity: NoteEntity)

    @Delete
    fun delete(entity: NoteEntity)
}