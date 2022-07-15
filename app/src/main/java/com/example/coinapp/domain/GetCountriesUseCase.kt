package com.example.coinapp.domain

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.adapter.GetCountriesQuery_ResponseAdapter
import com.example.coinapp.data.Repository.CountriesRepository
import com.example.coinapp.data.model.countries.CountriesModelList

class GetCountriesUseCase {
    private val repository = CountriesRepository()

    suspend operator fun invoke(): CountriesModelList = repository.getAllCountries()
}