package com.example.predict.models

import kotlinx.serialization.Serializable

@Serializable
data class Predict(
    val risk: Double,
    val timestamp: String,
    val yhat: Double,
    val yhat_lower: Double,
    val yhat_upper: Double
)