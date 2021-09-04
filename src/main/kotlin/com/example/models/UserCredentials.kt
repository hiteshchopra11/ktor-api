package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class UserCredentials(
    val username: String,
    val password: String
)