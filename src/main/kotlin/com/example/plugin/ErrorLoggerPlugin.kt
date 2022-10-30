package com.example.plugin

import io.ktor.server.application.*
import io.ktor.server.application.hooks.*

val ErrorLoggerPlugin = createApplicationPlugin(name = "ErrorLoggerPlugin") {
    on(CallFailed) { _, cause ->
        println("PLUGIN ERROR: API call failed because of ${cause.message}")
    }
}