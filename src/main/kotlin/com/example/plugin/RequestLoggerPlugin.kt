package com.example.plugin

import io.ktor.server.application.*
import io.ktor.server.plugins.*

val RequestLoggerPlugin = createApplicationPlugin(name = "RequestLoggerPlugin") {
    onCall { call ->
        call.request.origin.apply {
            println("Request URL: $scheme://$host:$port$uri")
        }
    }
}