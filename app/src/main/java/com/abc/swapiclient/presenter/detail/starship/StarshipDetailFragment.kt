package com.abc.swapiclient.presenter.detail.starship

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abc.swapiclient.R

class StarshipDetailFragment : Fragment() {

    companion object {
        fun newInstance() = StarshipDetailFragment()
    }

    private lateinit var viewModel: StarshipDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.starship_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StarshipDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}