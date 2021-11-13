package com.example.database

import org.jetbrains.exposed.sql.deleteWhere

fun delete_favorites(name_stock: String): Boolean {
    Favorites.deleteWhere { Favorites.symbol like "$name_stock" }
    return true
}