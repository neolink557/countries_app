package com.example.coinapp.data.network.coins

import com.example.coinapp.data.model.coin.CoinModelList
import com.example.coinapp.data.model.coindetail.CoinDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CoinsApiClient {
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getAllCoins(@Header("X-CMC_PRO_API_KEY") token: String) : Response<CoinModelList>

    @GET("/v2/cryptocurrency/info")
    suspend fun getCoinDetail(@Header("X-CMC_PRO_API_KEY") token: String,@Query("symbol") symbol: String) : Response<CoinDetail>

}