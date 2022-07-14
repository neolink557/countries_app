package com.example.coinapp.data.model.coin

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: String,
    val timestamp: String
)