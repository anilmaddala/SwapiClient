package com.abc.swapiclient.presenter.detail.person

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
import com.abc.swapiclient.databinding.PersonDetailFragmentBinding
import com.abc.swapiclient.presenter.util.ExpandableListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment : Fragment() {

    private val viewModel: PersonDetailViewModel by viewModels()

    private lateinit var binding: PersonDetailFragmentBinding

    private val args: PersonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.person_detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.loadPerson(args.id)

        viewModel.navigationAction.observe(viewLifecycleOwner, {
            findNavController().navigate(it)
        })
        return binding.root
    }
}