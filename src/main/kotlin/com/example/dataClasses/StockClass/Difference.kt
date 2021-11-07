package com.example.dataClasses.StockClass

import kotlinx.serialization.Serializable

@Serializable

data class Difference(
    var changesPercentage: Double,
    var change: Double,
    var isGrows: Boolean,
    val period: String
)