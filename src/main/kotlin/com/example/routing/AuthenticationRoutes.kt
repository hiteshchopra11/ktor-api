package com.example.routing


import com.example.data.auth.jwt.JwtConfig
import com.example.data.models.UserCredentials
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.concurrent.TimeUnit

fun Route.authenticateRoutes(secret: String, issuer: String, audience: String) {
    post("/generate-token") {
        val user = call.receive<UserCredentials>()
        println("${user.username} , pwd= ${user.password}")
        val token = JwtConfig.generateToken(user = user, issuer = issuer, secret = secret, audience = audience)
        call.respond(hashMapOf("token" to token))
    }

    authenticate("auth-jwt") {
        get("/test") {
            val principal = call.principal<JWTPrincipal>()
            val username = principal!!.payload.getClaim("username").asString()
            val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
            if (expiresAt != null) {
                call.respondText("Hi $username!! Your token expires in ${TimeUnit.MILLISECONDS.toMinutes(expiresAt)} minutes.")
            } else {
                call.respondText("Hi $username!! Your token expires soon")
            }
        }
    }
}