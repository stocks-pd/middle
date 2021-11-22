package com.example.search.models

import kotlinx.serialization.Serializable

@Serializable
data class Stock(
    var symbol: String,
    var company: String,
    var image: String,
    var type: String,
    val price: Price,
) {
    @Serializable
    data class Price(
        var value: Double,
        var currency: String,
        val differences: Difference
    ) {
        @Serializable
        data class Difference(
            var changesPercentage: Double,
            var change: Double,
            var isGrows: Boolean,
            val period: String
        )
    }
}