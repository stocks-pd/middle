package com.example.API

import com.example.database.delete_favorites
import com.example.database.postFavorites
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun postFavors(): Query {
    transaction {
        addLogger(StdOutSqlLogger)
        print(postFavorites())
    }
   return postFavorites()
}