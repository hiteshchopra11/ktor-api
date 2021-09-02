package com.example.routing


import com.example.jwt.JwtConfig
import com.example.models.UserCredentials
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.authenticateRoutes() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    routing {
        post("/generate_token") {
            val user = call.receive<UserCredentials>()
            println("${user.username} , pwd= ${user.password}")
            val token = JwtConfig.generateToken(user, issuer, secret, audience)
            call.respond(hashMapOf("token" to token))
        }

        authenticate("auth-jwt") {
            get("/test") {
                val principal = call.principal<JWTPrincipal>()
                val username = principal!!.payload.getClaim("username").asString()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
                println(call.response.status())
                call.respondText("Hi $username!! Your token expires at $expiresAt ms.")
            }
        }
    }
}