package com.abc.swapiclient.presenter.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abc.swapiclient.R
import com.abc.swapiclient.databinding.DetailFragmentBinding
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binding: DetailFragmentBinding

    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = args.count.toString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        binding.button.setOnClickListener {
//            val action = DetailFragmentDirections.actionDetailFragmentSelf(args.count + 1)
//            findNavController().navigate(action)
//        }
        lifecycleScope.launch {

        }
    }

}