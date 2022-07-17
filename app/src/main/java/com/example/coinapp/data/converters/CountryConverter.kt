package com.example.coinapp.data.converters

import com.example.coinapp.GetCountriesQuery
import com.example.coinapp.GetCountryQuery
import com.example.coinapp.data.model.countries.*

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

fun mapCountryToCountryDetailModel(country: GetCountryQuery.Data): CountryDetailModel {
    val countryDetailModel: CountryDetailModel
    country.country!!.apply {
        val continentModel = ContinentModel(continent.code, continent.name)
        val languagesModel = mutableListOf<LanguageModel>()
        languages.map { language ->
            languagesModel.add(
                LanguageModel(
                    language.code,
                    language.name.toString(),
                    language.native.toString()
                )
            )
        }

        countryDetailModel = CountryDetailModel(
            code,
            name,
            currency.toString(),
            continentModel,
            LanguagesModel(languagesModel),
            capital.toString()
        )
    }
    return countryDetailModel
}