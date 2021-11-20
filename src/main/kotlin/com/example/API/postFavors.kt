package com.example.API

import com.example.database.delete_favorites
import com.example.database.postFavorites
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun postFavors(): ResultRow {
    var res : ResultRow =
    transaction {
        addLogger(StdOutSqlLogger)
        postFavorites()
    }
    return res
}