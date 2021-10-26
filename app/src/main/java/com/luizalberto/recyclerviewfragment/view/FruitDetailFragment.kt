package com.luizalberto.recyclerviewfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.luizalberto.recyclerviewfragment.R
import com.luizalberto.recyclerviewfragment.databinding.FragmentFruitDetailBinding
import com.luizalberto.recyclerviewfragment.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fruit_list_content.*


@AndroidEntryPoint
class FruitDetailFragment : Fragment() {

    private val viewModel: MainViewModel by navGraphViewModels(R.id.nested_graph) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentFruitDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_fruit_detail,
            container,
            false)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel


        return binding.root
    }

}