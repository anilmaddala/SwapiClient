package com.abc.swapiclient.presenter.detail.starship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abc.swapiclient.R
import com.abc.swapiclient.databinding.StarshipDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Detail Fragment for Starship
 */
@AndroidEntryPoint
class StarshipDetailFragment : Fragment() {

    private val viewModel: StarshipDetailViewModel by viewModels()

    private lateinit var binding: StarshipDetailFragmentBinding

    private val args: StarshipDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.starship_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.loadStarship(args.id)

        viewModel.navigationAction.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        return binding.root
    }
}