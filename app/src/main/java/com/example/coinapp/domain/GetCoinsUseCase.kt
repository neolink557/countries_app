package com.example.coinapp.domain

import com.example.coinapp.data.Repository.CoinsRepository
import com.example.coinapp.data.model.coin.CoinModelList

class GetCoinsUseCase {
    private val repository = CoinsRepository()

    suspend operator fun invoke(): CoinModelList? = repository.getAllCoins()
}