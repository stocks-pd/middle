package com.example.database
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object favorites : Table() {
    val id = integer("id").autoIncrement() // Column<String>
    val symbol = varchar("symbol", length = 70) // Column<String>
    override val primaryKey = PrimaryKey(id, name = "stock_ID") // name is optional here
}

fun add_favorites(_name_stock: String): Boolean {
    val name_stock = _name_stock
    favorites.insert {
        it[symbol] = "$name_stock"
    }
    return true
}

fun delete_favorites(_name_stock: String): Boolean {
    val name_stock = _name_stock
    favorites.deleteWhere{ favorites.symbol like "$name_stock"}
    return true
}

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/stonks",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123"
    )
    transaction {
        addLogger(StdOutSqlLogger)
        //SchemaUtils.create(favorites)

    }
}