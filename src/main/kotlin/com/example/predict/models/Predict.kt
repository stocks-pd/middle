package com.example.predict.models

import kotlinx.serialization.Serializable

@Serializable
data class Predict(
    val ds: Double,
    val yhat: Double,
    val yhat_lower: Double,
    val yhat_upper: Double,
    val risk: Double,
)