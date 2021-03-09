package com.example.searchfilms.models.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class NoteEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val id_move: Int,
        val note: String?
)
