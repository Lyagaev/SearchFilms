package com.example.searchfilms.ui.film

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.searchfilms.R

class FilmDescriptionFragment : Fragment() {

    companion object {
        fun newInstance() = FilmDescriptionFragment()
    }

    private lateinit var viewModel: FilmDescriptionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_details_film, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmDescriptionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}