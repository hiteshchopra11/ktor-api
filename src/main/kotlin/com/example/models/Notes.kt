package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int,
    val note: String
)

@Serializable
data class NoteRequest(val note: String)

@Serializable
data class NoteResponse<T>(
    val data: T,
    val success: Boolean
)