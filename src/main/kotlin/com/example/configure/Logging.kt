package com.example.configure

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import org.slf4j.event.Level

fun Application.configureLogging() {
    install(CallLogging) {
        this.level = Level.INFO
    }
}