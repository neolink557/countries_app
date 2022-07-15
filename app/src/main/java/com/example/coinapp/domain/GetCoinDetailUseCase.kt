package com.example.coinapp.domain

import com.example.coinapp.data.Repository.CountriesRepository

class GetCoinDetailUseCase {
    private val repository = CountriesRepository()

//    suspend operator fun invoke(symbol:String): CoinDetail? = repository.getCoinDetail(symbol)
}