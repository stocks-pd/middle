package com.example.routes

import kotlinx.serialization.Serializable

@Serializable

data class Difference(
    val changesPercentage: Int,
    val change: Int,
    val isGrows: Boolean,
    val period: String
)