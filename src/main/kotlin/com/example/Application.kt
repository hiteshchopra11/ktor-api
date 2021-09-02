package com.example

import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {
    install(CallLogging)
    configureSerialization()
    configureJWT()
    configureRouting()
}
