package com.example.routes.FiltersClass

import kotlinx.serialization.Serializable

@Serializable

data class Filters(
    val filters: FiltersX,
    val sort: String
)