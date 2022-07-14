package com.example.coinapp.data.model.coin

data class ETH(
    val fully_diluted_market_cap: Double,
    val last_updated: String,
    val market_cap: Int,
    val market_cap_dominance: Int,
    val percent_change_1h: Int,
    val percent_change_24h: Int,
    val percent_change_7d: Int,
    val price: Int,
    val volume_24h: Int,
    val volume_change_24h: Double
)