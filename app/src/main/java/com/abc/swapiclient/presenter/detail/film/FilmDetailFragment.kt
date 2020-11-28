package com.abc.swapiclient.presenter.detail.film

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abc.swapiclient.R
import com.abc.swapiclient.databinding.FilmDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmDetailFragment : Fragment() {

    private val viewModel: FilmDetailViewModel by viewModels()

    private lateinit var binding: FilmDetailFragmentBinding

    private val args: FilmDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.film_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

//        viewModel.loadFilm(args.id)
//
//        viewModel.navigationAction.observe(viewLifecycleOwner, {
//            findNavController().navigate(it)
//        })
        return binding.root
    }
}