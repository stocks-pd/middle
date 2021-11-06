package com.example.routes.FiltersClass

import kotlinx.serialization.Serializable

@Serializable

data class FiltersX(
    val price: Double,
    val symbol: String
)