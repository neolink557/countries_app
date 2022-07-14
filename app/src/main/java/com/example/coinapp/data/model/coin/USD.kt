package com.example.coinapp.data.model.coin

data class USD(
    val fully_diluted_market_cap: String,
    val last_updated: String,
    val market_cap: String,
    val market_cap_dominance: String,
    val percent_change_1h: String,
    val percent_change_24h: String,
    val percent_change_7d: String,
    val price: String,
    val volume_24h: String,
    val volume_change_24h: String
)