package com.example.coinapp.domain

import com.example.coinapp.data.Repository.CoinsRepository
import com.example.coinapp.data.model.coindetail.CoinDetail

class GetCoinDetailUseCase {
    private val repository = CoinsRepository()

    suspend operator fun invoke(symbol:String): CoinDetail? = repository.getCoinDetail(symbol)
}