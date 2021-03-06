package com.abc.swapiclient.presenter.detail.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abc.swapiclient.R
import com.abc.swapiclient.databinding.FilmDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Detail Fragment for Film
 */
@AndroidEntryPoint
class FilmDetailFragment : Fragment() {

    private val viewModel: FilmDetailViewModel by viewModels()

    private lateinit var binding: FilmDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.film_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.navigationAction.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        return binding.root
    }
}