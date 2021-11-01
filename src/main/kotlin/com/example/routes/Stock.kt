package com.example.routes

import kotlinx.serialization.Serializable

@Serializable

data class Stock(
    val symbol: String,
    val company: String,
    val image: String,
    val type: String,
    val price: Price,
)