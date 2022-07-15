package com.example.coinapp.data.model.countries

import com.google.gson.annotations.SerializedName

data class CountriesModelList(
    @SerializedName("countries")
    val countries: List<CountryModel>
)