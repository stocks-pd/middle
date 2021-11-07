package com.example.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert

object Favorites : Table() {
    val id = integer("id").autoIncrement() // Column<String>
    val symbol = varchar("symbol", length = 70) // Column<String>
    override val primaryKey = PrimaryKey(id, name = "stock_ID") // name is optional here
}

fun add_favorites(name_stock: String): Boolean {
    Favorites.insert {
        it[symbol] = "$name_stock"
    }
    return true
}

