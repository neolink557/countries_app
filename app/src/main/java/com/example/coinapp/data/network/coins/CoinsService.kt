package com.example.platziappclon.data.network.achievements

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.core.RetrofitHelper.getRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoinsService {
    private val retrofit = getRetrofit()

    suspend fun getAllCountries(): GetCountriesQuery.Data? {
        return withContext(Dispatchers.IO) {
            val response = ApolloHelper.getApollo().query(GetCountriesQuery()).execute()
            response.data
        }
    }
}