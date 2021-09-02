package com.example.plugins

import com.example.jwt.JwtConfig
import com.example.models.UserCredentials
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*

fun Application.configureJWT() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val myRealm = environment.config.property("jwt.realm").getString()
    val audience = environment.config.property("jwt.audience").getString()
    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
            JwtConfig.getVerifier(secret, issuer, audience)
            validate {
                val username = it.payload.getClaim("username").asString()
                val password = it.payload.getClaim("password").asString()
                if (username != null && password != null) {
                    JWTPrincipal(it.payload)
                } else {
                    null
                }
            }
        }
    }
}