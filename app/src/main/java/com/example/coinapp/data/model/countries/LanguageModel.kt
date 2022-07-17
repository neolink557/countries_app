package com.example.coinapp.data.model.countries

import com.google.gson.annotations.SerializedName

data class LanguageModel(

    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("native")
    val native: String

)