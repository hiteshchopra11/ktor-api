package com.example.data.service

import com.example.data.models.Note
import com.example.data.repository.NotesRepository

class NotesServiceImpl(val notesRepository: NotesRepository) : NotesService {
    override fun addNote(note: String) {
        notesRepository.addNote(note)
    }

    override fun deleteNote(id: Int) {
        notesRepository.deleteNote(id)
    }

    override fun updateNote(id: Int, note: String) {
        notesRepository.updateNote(id, note)
    }

    override fun fetchNotes(): List<Note> {
        return notesRepository.fetchNotes()
    }
}