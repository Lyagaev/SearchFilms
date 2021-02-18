package com.example.searchfilms.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.R
import com.example.searchfilms.adapters.RecyclerAdapterCategories

class FragmentCategories: Fragment() {

    private lateinit var viewModel: ViewModelCategories
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_categories_films, container, false)
        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view_categories)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelCategories::class.java)

        val observer = Observer<MutableList<String>> { renderData(it) }
        viewModel.getData().observe(viewLifecycleOwner, observer)

    }

    private fun renderData(data: MutableList<String>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerAdapterCategories(data)
    }

}