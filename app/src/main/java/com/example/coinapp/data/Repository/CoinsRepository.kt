package com.example.coinapp.data.Repository

import com.example.coinapp.data.model.coin.CoinModelList
import com.example.coinapp.data.model.coindetail.CoinDetail
import com.example.platziappclon.data.network.achievements.CoinsService

class CoinsRepository {
    private val api = CoinsService()

    suspend fun getAllCoins(): CoinModelList? {
        return api.getAllCoins()
    }

    suspend fun getCoinDetail(symbol:String): CoinDetail? {
        return api.getCoinDetail(symbol)
    }

}