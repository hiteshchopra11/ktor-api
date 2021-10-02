package com.example.data.repository

import com.example.data.db.DatabaseConnection
import com.example.data.entities.NotesEntity
import com.example.data.models.Note
import org.ktorm.dsl.*

class NotesRepository {

    private val db = DatabaseConnection.database

    fun addNote(note: String): Int {
        return db.insert(NotesEntity) {
            set(it.note, note)
        }
    }

    fun deleteNote(id: Int): Int {
        return db.delete(NotesEntity) {
            it.id eq id
        }
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

    fun fetchPaginatedNotes(page: Int, size: Int): List<Note> {
        println("Fetching the paginated list of notes")
        val limit: Int = size
        val pageSize: Int = size
        val skip: Int = (page - 1) * pageSize
        return db.from(NotesEntity).select().limit(skip, limit).map {
            val id = it[NotesEntity.id]
            val note = it[NotesEntity.note]
            Note(id ?: -1, note ?: "")
        }
    }

    fun fetchNoteWithId(id: Int): Note? {
        return db.from(NotesEntity)
            .select()
            .where { NotesEntity.id eq id }
            .map {
                val note = it[NotesEntity.note]!!
                Note(id = id, note = note)
            }.firstOrNull()
    }
}