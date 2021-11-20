package com.example.database

import com.example.database.Favorites.symbol
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.selectAll

fun postFavorites(): Query {
    val FavorsResultRow = Favorites.select { Favorites.symbol eq "AAPL"}
    return FavorsResultRow
}