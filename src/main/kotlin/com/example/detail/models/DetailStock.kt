package com.example.detail.models

import kotlinx.serialization.Serializable

@Serializable
data class DetailStock(
    val ceo: String,
    val companyName: String,
    val country: String,
    val description: String,
    val industry: String,
    val sector: String,
    val symbol: String,
    val website: String
)