package com.example.searchfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.searchfilms.ui.film.FilmDescriptionFragment

class FilmDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_description_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FilmDescriptionFragment.newInstance())
                    .commitNow()
        }
    }
}