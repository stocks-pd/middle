package com.example.database

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

fun Application.DataBaseConnection() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/stonks",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123"
    )
}