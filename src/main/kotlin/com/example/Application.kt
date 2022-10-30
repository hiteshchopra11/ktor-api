package com.example

import com.example.configure.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureKoin()
    configureLogging()
    configureSerialization()
    configureJWT()
    configureRouting()
}
