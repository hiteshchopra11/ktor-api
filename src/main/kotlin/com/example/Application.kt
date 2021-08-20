package com.example

import com.example.entities.NotesEntity
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.ktorm.database.Database
import org.ktorm.dsl.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
