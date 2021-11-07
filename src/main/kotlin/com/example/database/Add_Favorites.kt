package com.example.database

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

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

fun delete_favorites(name_stock: String): Boolean {
    Favorites.deleteWhere { Favorites.symbol like "$name_stock" }
    return true
}
