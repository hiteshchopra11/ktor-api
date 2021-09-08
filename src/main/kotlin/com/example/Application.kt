package com.example

import com.example.plugins.*
import io.ktor.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureKoin()
    configureLogging()
    configureSerialization()
    configureJWT()
    configureRouting()
}
