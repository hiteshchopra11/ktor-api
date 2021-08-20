package com.example.models

import kotlinx.serialization.Serializable
import org.mindrot.jbcrypt.BCrypt

@Serializable
data class UserCredentials(
    val username:String,
    val password:String
) {
    fun hashedPassword():String {
        return BCrypt.hashpw(password,BCrypt.gensalt())
    }
}