package com.example.database
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction



object Users : Table() {
    val id = varchar("id", 10) // Column<String>
    val name = varchar("name", length = 50) // Column<String>

    override val primaryKey = PrimaryKey(id, name = "PK_User_ID") // name is optional here
}

object customers : Table() {
    val Name = varchar("Name", length = 50) // Column<String>

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
        //customers.insert {
          //  it[Name] = "Andrey"
        //}


    }
}