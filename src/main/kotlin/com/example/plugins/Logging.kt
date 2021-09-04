package com.example.plugins

import io.ktor.application.*
import io.ktor.features.*
import org.slf4j.event.Level

fun Application.configureLogging() {
    install(CallLogging) {
        level = Level.DEBUG
    }
}