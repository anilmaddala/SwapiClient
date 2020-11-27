package com.abc.swapiclient.presenter.detail.species

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abc.swapiclient.R

class SpeciesDetailFragment : Fragment() {

    companion object {
        fun newInstance() = SpeciesDetailFragment()
    }

    private lateinit var viewModel: SpeciesDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.species_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeciesDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}