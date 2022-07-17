package com.example.coinapp.data.Repository

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.GetCountryQuery
import com.example.coinapp.data.converters.mapCountryToCountryDetailModel
import com.example.coinapp.data.converters.mapCountryToCountryModel
import com.example.coinapp.data.model.countries.CountriesModelList
import com.example.coinapp.data.model.countries.CountryDetailModel
import com.example.coinapp.data.network.coins.CountryService

class CountriesRepository {
    private val api = CountryService()

    suspend fun getAllCountries(): CountriesModelList? {
        val response = api.getAllCountries()
        return if (response is GetCountriesQuery.Data) mapCountryToCountryModel(response)
        else null
    }

    suspend fun getCountryByCode(code:String): CountryDetailModel? {
        val response = api.getCountryById(code)
        return if (response is GetCountryQuery.Data) mapCountryToCountryDetailModel(response)
        else null
    }
}