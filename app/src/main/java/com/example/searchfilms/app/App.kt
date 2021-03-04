package com.example.searchfilms.app

import android.app.Application
import androidx.room.Room
import com.example.searchfilms.models.room.NoteDao
import com.example.searchfilms.models.room.NoteDataBase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {

        private var appInstance: App? = null
        private var db: NoteDataBase? = null
        private const val DB_NAME = "Note.db"

        fun getNoteDao(): NoteDao {
            if (db == null) {
                synchronized(NoteDataBase::class.java) {
                    if (db == null) {
                        if (appInstance == null) throw IllegalStateException("Application is null while creating DataBase")
                        db = Room.databaseBuilder(
                                appInstance!!.applicationContext,
                                NoteDataBase::class.java,
                                DB_NAME)
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }

            return db!!.noteDao()
        }
    }

}