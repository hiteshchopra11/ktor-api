package com.example.configure

import com.example.di.notesModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(notesModule)
    }
}