package com.example.routes.StockClass

import com.example.routes.StockClass.Difference
import kotlinx.serialization.Serializable

@Serializable

data class Price(
    var value: Double,
    var currency: String,
    val differences: Difference
)