package com.example.coinapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}