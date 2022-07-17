package com.example.coinapp.data.network.coins

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.GetCountryQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryService {

    suspend fun getAllCountries(): GetCountriesQuery.Data? {
        return withContext(Dispatchers.IO) {
            val response = ApolloHelper.getApollo().query(GetCountriesQuery()).execute()
            response.data
        }
    }

    suspend fun getCountryById(code:String): GetCountryQuery.Data? {
        return withContext(Dispatchers.IO) {
            val response = ApolloHelper.getApollo().query(GetCountryQuery(code)).execute()
            response.data
        }
    }
}