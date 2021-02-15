package com.example.searchfilms.fragments.detailsFilm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.searchfilms.models.Film
import com.example.searchfilms.R
import kotlinx.android.synthetic.main.fragment_details_film.*

class FragmentDetailsFilms: Fragment() {

    private lateinit var viewModel: ViewModelDetailsFilms

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root= inflater.inflate(R.layout.fragment_details_film, container, false)
        var tvDetailsHeader = root.findViewById<TextView>(R.id.tvDetailsHeader)
        var tvDetailsDescription = root.findViewById<TextView>(R.id.tv_details_description)

        val film = arguments?.getParcelable<Film>(BUNDLE_EXTRA)
        film?.let {

            tvDetailsHeader.text = it.name
            tvDetailsDescription.text ="Описание фильма"
        }

        return root;
    }

    companion object {
        const val BUNDLE_EXTRA = "film"

        fun newInstance(bundle: Bundle): FragmentDetailsFilms {
            val fragment = FragmentDetailsFilms()
            fragment.arguments = bundle
            return fragment
        }
    }
}