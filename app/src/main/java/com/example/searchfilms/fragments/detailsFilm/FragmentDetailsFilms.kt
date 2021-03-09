package com.example.searchfilms.fragments.detailsFilm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchfilms.models.Film
import com.example.searchfilms.R
import com.example.searchfilms.databinding.FragmentDetailsFilmBinding
import com.example.searchfilms.databinding.FragmentSettingsBinding
import com.example.searchfilms.models.BASE_URL_IMAGE
import com.example.searchfilms.models.FilmNote
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_note_edit.view.*
import kotlinx.android.synthetic.main.fragment_details_film.*
import kotlinx.android.synthetic.main.recyclerview_popular_item.view.*

class FragmentDetailsFilms: Fragment() {

    private val viewModel: ViewModelDetailsFilms by lazy { ViewModelProvider(this).get(ViewModelDetailsFilms::class.java) }
    private lateinit var binding: FragmentDetailsFilmBinding
    private var idMovie=0
    private var noteFilm=""

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentDetailsFilmBinding.inflate(inflater)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val film = arguments?.getParcelable<Film>(BUNDLE_EXTRA)
        film?.let { it ->
            idMovie=it.id
            binding.tvDetailsHeader.text = it.name
            binding.tvDetailsDescription.text =it.description
            Picasso
                    .get()
                    .load(BASE_URL_IMAGE + "w400/" +film.backdropPath)
                    .into(binding.ivPoster);
            binding.editNoteFAB.setOnClickListener {show(idMovie) }

            viewModel.getNote(idMovie)?.let{ nullNote->
                noteFilm= nullNote
                binding.textViewNote.text = noteFilm
            }

        }
    }

    private fun show(id : Int){
        val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_note_edit, null)
        mDialogView.et_note.setText(noteFilm)
        val mBuilder = AlertDialog.Builder(requireContext())
                .setView(mDialogView)
                .setTitle("Заметка к фильму")
        val  mAlertDialog = mBuilder.show()

        mDialogView.btn_note_save.setOnClickListener {
            mAlertDialog.dismiss()
            val note = mDialogView.et_note.text.toString()

            if (noteFilm=="")
                viewModel.saveNoteToDB(FilmNote(id, note))
            else
                viewModel.updateNoteToDB(FilmNote(id, note))

        }
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