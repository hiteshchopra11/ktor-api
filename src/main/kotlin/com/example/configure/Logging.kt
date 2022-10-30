package com.example.configure

import com.example.plugin.ErrorLoggerPlugin
import com.example.plugin.RequestLoggerPlugin
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import org.slf4j.event.Level

fun Application.configureLogging() {
    install(ErrorLoggerPlugin)
    install(RequestLoggerPlugin)
    install(CallLogging) {
        this.level = Level.INFO
    }
}