package com.example.data.repository

import com.example.data.db.DatabaseConnection
import com.example.data.entities.NotesEntity
import com.example.data.models.Note
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

class NotesRepository {

    val db = DatabaseConnection.database

    fun addNote(note: String) {
        println("Note Added $note")
    }

    fun deleteNote(id: Int) {
        println("Note with id $id deleted")
    }

    fun updateNote(id: Int, note: String) {
        println("Note with id $id is updated with text $note")
    }

    fun fetchNotes(): List<Note> {
        println("Fetching the notes")
        return db.from(NotesEntity).select().map {
            val id = it[NotesEntity.id]
            val note = it[NotesEntity.note]
            Note(id ?: -1, note ?: "")
        }
    }
}