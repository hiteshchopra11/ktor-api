package com.example.routing

import com.example.db.DatabaseConnection
import com.example.entities.UserEntity
import com.example.models.UserCredentials
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.insert
import java.util.*

fun Application.authenticateRoutes() {
    val db = DatabaseConnection.database

    routing {
        post("/register") {
            val userCredentials = call.receive<UserCredentials>()
            val userName = userCredentials.username.lowercase(Locale.getDefault())
            val password = userCredentials.hashedPassword()
            db.insert(UserEntity) {
                set(it.userName, userName)
                set(it.password, password)
            }
            call.respondText("Logged In Successfully")
        }
    }
}