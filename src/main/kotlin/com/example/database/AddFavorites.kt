package com.example.database

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert

@Serializable
data class Favor (val id : Int? = null, val symbol: String)

object Favorites : Table() {
    val id = integer("id").autoIncrement() // Column<String>
    val symbol = varchar("symbol", length = 70) // Column<String>
    override val primaryKey = PrimaryKey(id, name = "stock_ID") // name is optional here

    fun toFavors(row: ResultRow): Favor =
        Favor(
            id = row[Favorites.id],
            symbol = row[Favorites.symbol]
        )

}

fun add_favorites(name_stock: String): Boolean {
    Favorites.insert {
        it[symbol] = "$name_stock"
    }
    return true
}

