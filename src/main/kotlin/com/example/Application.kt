package com.example

import com.example.plugins.configureJWT
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.metrics.micrometer.*
import io.ktor.server.netty.*
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {
    install(CallLogging) {
        level = Level.TRACE
    }
    val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
    install(MicrometerMetrics) {
        registry = appMicrometerRegistry
    }
    configureSerialization()
    configureJWT()
    configureRouting()
}
