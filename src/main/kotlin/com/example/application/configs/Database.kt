package com.example.application.configs

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

fun configureDataBase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/stonks",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123"
    )
    transaction {
//        SchemaUtils.create( // if not exists
//             здесь нужно будет написать обжекты таблиц через запятую, когда они будут.
//             если какая-то таблица еще не создана она создастся здесь
//        )
    }
}