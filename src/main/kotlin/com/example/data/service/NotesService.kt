package com.example.data.service

import com.example.data.models.Note

interface NotesService {
    fun addNote(note: String): Int
    fun deleteNote(id: Int): Int
    fun updateNote(id: Int, note: String)
    fun fetchAllNotes(): List<Note>
    fun fetchNoteWithId(id: Int): Note?
    fun fetchAllPaginatedNotes(page: Int, size: Int): List<Note>
    fun fetchSortedNotes(isDescending: Boolean? = false): List<Note>
}