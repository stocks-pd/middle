package com.example.favorites.post

import com.example.API.postFavors
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.postFavorsRouting() {
    route("/favors") {
        post {
            //------------------------------
            val favors = postFavors()
            call.respond(favors)
        }
    }
}