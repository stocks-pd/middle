package com.example.routes

import kotlinx.serialization.Serializable

@Serializable

data class FiltersX(
    val price: Double,
    val symbol: String
)