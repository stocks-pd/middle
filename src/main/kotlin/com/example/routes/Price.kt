package com.example.routes

import kotlinx.serialization.Serializable

@Serializable

data class Price(
    val value: Double,
    val currency: Difference,
    val differences: Difference
)