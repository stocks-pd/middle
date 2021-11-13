package com.example.application.configs

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun configureDataBase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/stonks",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123"
    )

    transaction {
//        SchemaUtils.create( // if not exists
//
//        )
    }
}