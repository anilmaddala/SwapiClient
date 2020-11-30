package com.abc.swapiclient.presenter.detail.vehicle

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
import com.abc.swapiclient.databinding.VehicleDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Detail Fragment for Vehicles
 */
@AndroidEntryPoint
class VehicleDetailFragment : Fragment() {

    private val viewModel: VehicleDetailViewModel by viewModels()

    private lateinit var binding: VehicleDetailFragmentBinding

    private val args: VehicleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.vehicle_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.loadVehicle(args.id)

        viewModel.navigationAction.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        return binding.root
    }
}