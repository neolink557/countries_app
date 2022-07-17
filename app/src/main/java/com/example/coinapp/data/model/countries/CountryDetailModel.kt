package com.example.coinapp.data.model.countries

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

data class CountryDetailModel(

    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("continent")
    val continent: ContinentModel,
    @SerializedName("languages")
    val languages: LanguagesModel,
    @SerializedName("capital")
    val capital: String,


)