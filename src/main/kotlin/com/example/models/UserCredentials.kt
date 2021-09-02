package com.example.models

import io.ktor.auth.*
import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class UserCredentials(
    val username: String,
    val password: String
) : Principal