package com.example.coinapp.data.converters

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.data.model.countries.ContinentModel
import com.example.coinapp.data.model.countries.CountriesModelList
import com.example.coinapp.data.model.countries.CountryModel

fun mapCountryToCountryModel(countries: GetCountriesQuery.Data):CountriesModelList {
    var countriesModelList = mutableListOf<CountryModel>()

    countries.countries.map { country ->
        var continentModel = ContinentModel(country.continent.code, country.continent.name)
        var countryModel =
            CountryModel(country.code, country.name, continentModel, country.capital.toString())
        countriesModelList.add(countryModel)
    }
    return CountriesModelList(countriesModelList)
}