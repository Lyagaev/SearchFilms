package com.example.searchfilms.fragments.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.Film
import com.example.searchfilms.R
import com.example.searchfilms.adapters.RecyclerAdapterFilms

class FragmentPopular: Fragment() {

    private lateinit var viewModel: ViewModelPopular
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root= inflater.inflate(R.layout.fragment_popular_name, container, false)
        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view_popular)

        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelPopular::class.java)

        val observer = Observer<MutableList<Film>> { renderData(it) }
        viewModel.getData().observe(viewLifecycleOwner, observer)
    }

    private fun renderData(data: MutableList<Film>) {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = RecyclerAdapterFilms(data)
    }





}