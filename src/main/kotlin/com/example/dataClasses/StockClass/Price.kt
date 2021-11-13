package com.example.dataClasses.StockClass

import kotlinx.serialization.Serializable

@Serializable

data class Price(
    var value: Double,
    var currency: String,
    val differences: Difference
)