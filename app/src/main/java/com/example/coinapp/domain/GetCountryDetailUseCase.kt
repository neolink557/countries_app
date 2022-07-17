package com.example.coinapp.domain

import com.example.coinapp.data.Repository.CountriesRepository
import com.example.coinapp.data.model.countries.CountryDetailModel

class GetCountryDetailUseCase {
    private val repository = CountriesRepository()

    suspend operator fun invoke(code: String): CountryDetailModel? = repository.getCountryByCode(code)
}