package com.example.plugins

import com.example.di.notesModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(notesModule)
    }
}