package com.example.favorites.post

import com.example.database.postFavorites
import com.example.search.models.Stock
import com.example.search.use_cases.SearchUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.postFavorsRouting() {
    route("/favors") {
        post {
            val favors = postFavorites()
            var count = favors.count()
            count--
            var respondList = mutableListOf<Stock>()
            for (i in 0..count) {
                var respond = SearchUseCase().execute(favors[i].symbol)
                respondList.add(respond[0])
            }
            call.respond(respondList)
        }
    }
}

