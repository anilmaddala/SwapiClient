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

    lateinit var listDataHeader: List<String>
    lateinit var listDataChild: HashMap<String, List<String>>

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

        prepareListData()
        val adapter = ExpandableListAdapter(requireContext(), listDataHeader, listDataChild)
        binding.expandableListView.setAdapter(adapter)

        return binding.root
    }

    private fun prepareListData() {
        listDataHeader = ArrayList()
        listDataChild = HashMap()

        // Adding child data
        (listDataHeader as ArrayList<String>).add("Films")
        (listDataHeader as ArrayList<String>).add("Vehicles")
        (listDataHeader as ArrayList<String>).add("Starships")

        // Adding child data
        val films: MutableList<String> = ArrayList()
        films.add("http://swapi.dev/api/films/1/")
        films.add("http://swapi.dev/api/films/2/")
        films.add("http://swapi.dev/api/films/3/")
        films.add("http://swapi.dev/api/films/6/")

        val vehicles: MutableList<String> = ArrayList()
        vehicles.add("http://swapi.dev/api/vehicles/14/")
        vehicles.add("http://swapi.dev/api/vehicles/30/")

        val starships: MutableList<String> = ArrayList()
        starships.add("http://swapi.dev/api/starships/12/")
        starships.add("http://swapi.dev/api/starships/22/")

        listDataChild[listDataHeader[0]] = films // Header, Child data
        listDataChild[listDataHeader[1]] = vehicles
        listDataChild[listDataHeader[2]] = starships
    }
}