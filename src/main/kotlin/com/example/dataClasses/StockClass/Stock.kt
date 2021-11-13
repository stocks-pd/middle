package com.example.dataClasses.StockClass

import kotlinx.serialization.Serializable

@Serializable

data class Stock(
    var symbol: String,
    var company: String,
    var image: String,
    var type: String,
    val price: Price,
)