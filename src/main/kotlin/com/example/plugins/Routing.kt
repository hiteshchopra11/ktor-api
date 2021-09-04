package com.example.plugins

import com.example.routing.authenticateRoutes
import com.example.routing.notesRoutes
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }

    notesRoutes()
    authenticateRoutes()
}
