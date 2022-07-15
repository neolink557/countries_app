package com.example.coinapp.data.Repository

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.data.converters.mapCountryToCountryModel
import com.example.coinapp.data.model.countries.CountriesModelList
import com.example.platziappclon.data.network.achievements.CoinsService

class CountriesRepository {
    private val api = CoinsService()

    suspend fun getAllCountries(): CountriesModelList {
        val response = api.getAllCountries()
        return if (response is GetCountriesQuery.Data) mapCountryToCountryModel(response)
        else CountriesModelList(mutableListOf())
    }

}