package com.example.coinapp.data.model.countries

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

data class CountryModel(

    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("continent")
    val continent: ContinentModel,
    @SerializedName("capital")
    val capital: String,


)