package com.example.data.service

import com.example.data.models.Note

interface NotesService {
    fun addNote(note: String)
    fun deleteNote(id: Int)
    fun updateNote(id: Int, note: String)
    fun fetchNotes(): List<Note>
}