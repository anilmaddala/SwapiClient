package com.abc.swapiclient.presenter.detail.planet

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abc.swapiclient.R
import dagger.hilt.android.AndroidEntryPoint

class PlanetDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PlanetDetailFragment()
    }

    private lateinit var viewModel: PlanetDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.planet_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlanetDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}