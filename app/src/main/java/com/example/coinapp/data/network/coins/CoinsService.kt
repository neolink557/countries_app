package com.example.platziappclon.data.network.achievements

import com.example.coinapp.core.RetrofitHelper.getRetrofit
import com.example.coinapp.data.model.coin.CoinModelList
import com.example.coinapp.data.model.coindetail.CoinDetail
import com.example.coinapp.data.network.coins.CoinsApiClient
import com.example.coinapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsService {
    private val retrofit = getRetrofit()

    suspend fun getAllCoins(): CoinModelList? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CoinsApiClient::class.java).getAllCoins(Constants().AUTH_TOKEN)
            response.body()
        }
    }

    suspend fun getCoinDetail(symbol:String): CoinDetail? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CoinsApiClient::class.java).getCoinDetail(Constants().AUTH_TOKEN,symbol)
            val x = response
            response.body()
        }
    }

}