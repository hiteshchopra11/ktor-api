package com.example.plugins

import com.example.jwt.JwtConfig
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
            verifier(JwtConfig.getVerifier(secret = secret, issuer = issuer, audience = audience))
            validate { credential ->
                if (credential.payload.getClaim("username").asString() != "" &&
                    credential.payload.getClaim("password").asString() != ""
                ) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
}