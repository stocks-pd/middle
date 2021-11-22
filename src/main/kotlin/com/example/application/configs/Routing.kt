package com.example.application.configs



import com.example.favorites.delete.deleteFavorsRouting
import com.example.favorites.post.postFavorsRouting
import com.example.favorites.put.putFavorsRouting
import com.example.search.searchRouting
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello")
        }
    }
    routing {
        searchRouting()
        putFavorsRouting()
        postFavorsRouting()
        deleteFavorsRouting()
    }
}
