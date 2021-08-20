package com.example.models

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class NoteResponse<T>(
    val data: T,
    val success: Boolean
)