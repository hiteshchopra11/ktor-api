package com.example

import com.example.plugins.configureJWT
import com.example.plugins.configureLogging
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureLogging()
    configureSerialization()
    configureJWT()
    configureRouting()
}
