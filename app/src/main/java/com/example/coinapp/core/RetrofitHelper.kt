package com.example.coinapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://countryflagsapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}