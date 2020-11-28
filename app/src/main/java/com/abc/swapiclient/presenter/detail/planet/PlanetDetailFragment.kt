package com.abc.swapiclient.presenter.detail.planet

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
import com.abc.swapiclient.databinding.PlanetDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetDetailFragment : Fragment() {

    private val viewModel: PlanetDetailViewModel by viewModels()

    private lateinit var binding: PlanetDetailFragmentBinding

    private val args: PlanetDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.planet_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.loadPlanet(args.id)

        viewModel.navigationAction.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        return binding.root
    }
}