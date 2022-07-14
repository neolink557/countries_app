package com.example.coinapp.ui.coins

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinapp.data.model.coin.CoinModel
import com.example.coinapp.data.model.coin.CoinModelList
import com.example.coinapp.data.model.states.State
import com.example.coinapp.databinding.CoinFragmentBinding
import com.example.coinapp.ui.coins.adapters.CoinFragmentAdapter

class CoinFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: CoinFragmentBinding? = null


    private lateinit var adapterCoin: CoinFragmentAdapter
    private val viewModel: CoinViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CoinFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
    }

    private fun setUpObservers() {

        viewModel.coinsDetail.observe(viewLifecycleOwner, Observer { result ->
            when (result.first) {
                State.SUCCESS -> {
                }
                State.ERROR -> Toast.makeText(
                    requireContext(),
                    "oh no,there's an error, try again later",
                    Toast.LENGTH_LONG
                ).show()
                State.LOADING -> {
                }
            }
        })

        viewModel.coinsModel.observe(viewLifecycleOwner, Observer { result ->
            when (result.first) {
                State.SUCCESS -> setUpCoinAdapter(result.second?.data?.take(10) as List<CoinModel>)
                State.ERROR -> Toast.makeText(
                    requireContext(),
                    "oh no,there's an error, try again later",
                    Toast.LENGTH_LONG
                ).show()
                State.LOADING -> {
                }
            }
        })
    }

    private fun setUpView() {
        viewModel.getLessonsDetail()
        binding.apply {
        }
    }

    private fun setUpCoinAdapter(coin: List<CoinModel>) {
        adapterCoin = CoinFragmentAdapter(coin) { coin -> onCoinItemClicked(coin) }

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

    private fun onCoinItemClicked(coin: CoinModel) {
        viewModel.getLessonsDetail("BTC")
        //val action = HomeFragmentDirections.actionNavigationStudyToLessonsFragmentBottomSheetDialog(coin)
        //findNavController().navigate(action)
    }

}