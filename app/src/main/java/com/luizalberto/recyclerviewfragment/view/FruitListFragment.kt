package com.luizalberto.recyclerviewfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.RecyclerView
import com.luizalberto.recyclerviewfragment.R
import com.luizalberto.recyclerviewfragment.model.Fruit
import com.luizalberto.recyclerviewfragment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitListFragment : Fragment() {

    private val viewModel: MainViewModel by navGraphViewModels(R.id.nested_graph) {
        defaultViewModelProviderFactory
    }

    companion object {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_fruit_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.item_list)

        viewModel.getFruits().observe(viewLifecycleOwner, Observer<List<Fruit>>{ fruits ->
            recyclerView.adapter = FruitListAdapter(fruits.sortedBy { it.id }) {
                viewModel.select(it)
                findNavController().navigate(R.id.action_fruitListFragment_to_fruitDetailFragment)
            }
        })

        return view
    }

}