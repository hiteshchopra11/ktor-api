package com.example.plugins

import com.example.routing.authenticateRoutes
import com.example.routing.notesRoutes
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    routing {
        notesRoutes()
        authenticateRoutes(secret, issuer, audience)
    }
}