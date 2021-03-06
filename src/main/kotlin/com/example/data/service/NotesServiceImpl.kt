package com.example.data.service

import com.example.data.models.Note
import com.example.data.repository.NotesRepository

class NotesServiceImpl(val notesRepository: NotesRepository) : NotesService {
    override fun addNote(note: String): Int {
        return notesRepository.addNote(note)
    }

    override fun deleteNote(id: Int): Int {
        return notesRepository.deleteNote(id)
    }

    override fun updateNote(id: Int, note: String) {
        return notesRepository.updateNote(id, note)
    }

    override fun fetchAllNotes(): List<Note> {
        return notesRepository.fetchNotes()
    }

    override fun fetchNoteWithId(id: Int): Note? {
        return notesRepository.fetchNoteWithId(id)
    }
}