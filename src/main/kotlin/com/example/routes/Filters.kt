package com.example.routes

import kotlinx.serialization.Serializable

@Serializable

data class Filters(
    val filters: FiltersX,
    val sort: String
)