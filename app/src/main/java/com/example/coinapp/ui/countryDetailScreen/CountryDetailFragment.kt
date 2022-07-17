package com.example.coinapp.ui.countryDetailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.coinapp.R
import com.example.coinapp.data.model.countries.CountryDetailModel
import com.example.coinapp.data.model.countries.LanguagesModel
import com.example.coinapp.data.model.states.State
import com.example.coinapp.databinding.FragmentCountryDetailBinding

class CountryDetailFragment : Fragment() {
    val args: CountryDetailFragmentArgs by navArgs()
    private val binding get() = _binding!!
    private var _binding: FragmentCountryDetailBinding? = null

    private val viewModel: CountryDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getCountries(args.countryCode)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.countryModel.observe(viewLifecycleOwner) { result ->
            when (result.first) {
                State.SUCCESS -> {
                    inflateView(result.second!!)
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

    private fun inflateView(country: CountryDetailModel) {
        binding.apply {
            title.title = country.name
            Glide.with(requireContext()).load("https://countryflagsapi.com/png/${country.code}").centerCrop().into(background)

            code.title.text = resources.getString(R.string.code)
            capital.title.text = resources.getString(R.string.capital)
            currency.title.text = resources.getString(R.string.currency)
            continent.title.text = resources.getString(R.string.continent)
            languages.title.text = resources.getString(R.string.languages)

            code.descriptionTxt.text = country.code
            capital.descriptionTxt.text = country.capital
            currency.descriptionTxt.text = country.currency
            continent.descriptionTxt.text = country.continent.name
            languages.descriptionTxt.text = formatLanguages(country.languages)
        }
    }

    private fun formatLanguages(languages: LanguagesModel): String {
        var lang = ""
        languages.language.map {
            lang += "${it.name}, "
        }
        try {
            return lang.substring(0, lang.length - 2)
        }catch (e:Exception){
            return lang
        }

    }

}