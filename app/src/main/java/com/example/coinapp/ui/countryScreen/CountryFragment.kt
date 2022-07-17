package com.example.coinapp.ui.countryScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinapp.data.model.countries.CountryModel
import com.example.coinapp.data.model.states.State
import com.example.coinapp.databinding.CountryFragmentBinding
import com.example.coinapp.ui.countryScreen.adapters.CountriesFragmentAdapter

class CountryFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: CountryFragmentBinding? = null


    private lateinit var adapterCoin: CountriesFragmentAdapter
    private val viewModel: CoinViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CountryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
    }

    private fun setUpObservers() {

        viewModel.countryModel.observe(viewLifecycleOwner) { result ->
            when (result.first) {
                State.SUCCESS -> {
                    setUpCountryAdapter(result.second!!.countries.take(15)) //here we can modify the request to give them pagination, for time propourses i only take the firsts 15 data
                }
                State.ERROR -> Toast.makeText(
                    requireContext(),
                    "oh no,there's an error, try again later",
                    Toast.LENGTH_LONG
                ).show()
                State.LOADING -> {
                }
            }
        }


    }

    private fun setUpView() {
        viewModel.getCountries()
        binding.apply {

        }
    }

    private fun setUpCountryAdapter(countries: List<CountryModel>) {
        adapterCoin = CountriesFragmentAdapter(countries) { country -> onCountryItemClicked(country) }

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.apply {
            recyclerCoin.layoutManager = layoutManager
            recyclerCoin.adapter = adapterCoin
        }

    }

    private fun onCountryItemClicked(country: CountryModel) {
        val action = CountryFragmentDirections.actionCoinFragmentToCountryDetailFragment2(country.code)
        findNavController().navigate(action)
    }

}