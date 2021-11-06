package com.example.routes.ForecastJson1Class

data class forecastJson1Item(
    val avgVolume: Int,
    val change: Double,
    val changesPercentage: Double,
    val dayHigh: Double,
    val dayLow: Double,
    val earningsAnnouncement: String,
    val eps: Double,
    val exchange: String,
    val marketCap: Double,
    val name: String,
    val `open`: Double,
    val pe: Double,
    val previousClose: Double,
    val price: Double,
    val priceAvg200: Double,
    val priceAvg50: Double,
    val sharesOutstanding: Long,
    var symbol: String,
    val timestamp: Int,
    val volume: Int,
    val yearHigh: Double,
    val yearLow: Double
)