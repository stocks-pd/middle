package com.example.routes.StockClass

import com.example.routes.StockClass.Price
import kotlinx.serialization.Serializable

@Serializable

data class Stock(
    var symbol: String,
    var company: String,
    var image: String,
    val type: String,
    val price: Price,
)