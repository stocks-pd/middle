package com.example.database

import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun postFavorites(): List<Favor> {

    val fav = transaction {
        addLogger(StdOutSqlLogger)
        Favorites.selectAll().map { Favorites.toFavors(it) }
    }
    return fav
}