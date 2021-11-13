package com.example.dataClasses.listStocks
import kotlinx.serialization.Serializable

@Serializable
data class ListStocksItem(
    val exchange: String,
    val exchangeShortName: String,
    val name: String,
    val price: Double,
    val symbol: String,
    val type: String
)