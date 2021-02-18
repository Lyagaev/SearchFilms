package com.example.searchfilms.fragments.newFilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.models.Film
import com.example.searchfilms.R
import com.example.searchfilms.adapters.RecyclerAdapterFilms
import com.example.searchfilms.fragments.detailsFilm.FragmentDetailsFilms
import com.example.searchfilms.models.AppState
import com.example.searchfilms.models.OnItemViewClickListener
import com.example.searchfilms.models.showSnackBar
import kotlinx.android.synthetic.main.fragment_new_films.*
import kotlinx.android.synthetic.main.fragment_popular_films.*

class FragmentNewFilms: Fragment() {

    private lateinit var viewModel: ViewModelNewFilms
    private val adapter = RecyclerAdapterFilms(object : OnItemViewClickListener {
        override fun onItemViewClick(film: Film) {
            val manager = activity?.supportFragmentManager
            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(FragmentDetailsFilms.BUNDLE_EXTRA, film)
                manager.beginTransaction()
                        .add(R.id.container, FragmentDetailsFilms.newInstance(bundle))
                        .addToBackStack("")
                        .commitAllowingStateLoss()
            }
        }
    })
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root= inflater.inflate(R.layout.fragment_new_films, container, false)
        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view_new)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter

        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelNewFilms::class.java)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getData().observe(viewLifecycleOwner, observer)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                loadingFragmentNewFilm.visibility = View.GONE
                adapter.setFilms(appState.filmData)
            }
            is AppState.Loading -> {
                loadingFragmentNewFilm.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                loadingFragmentNewFilm.visibility = View.GONE
                view?.let {
                    requireView().showSnackBar(
                            getString(R.string.error),
                            getString(R.string.reload),
                            { viewModel.getGenerateDataFromLocalSource() })
                }
            }
        }
    }
}