package com.example.routing

import com.example.data.db.DatabaseConnection
import com.example.data.entities.NotesEntity
import com.example.data.models.NoteRequest
import com.example.data.models.NoteResponse
import com.example.data.service.NotesService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
import org.ktorm.dsl.eq
import org.ktorm.dsl.update

fun Application.notesRoutes() {
    val db = DatabaseConnection.database

    // Lazy inject NotesService
    val service: NotesService by inject()

    routing {
        get("/notes") {
            call.respond(service.fetchAllNotes())
        }

        post("/notes") {
            val request = call.receive<NoteRequest>()
            val result = service.addNote(request.note)

            // Verify only 1 row has been inserted
            if (result == 1) {
                // To Successful response to the client
                call.respond(
                    HttpStatusCode.OK,
                    NoteResponse(
                        success = true,
                        data = "Value has been successfully inserted"
                    )
                )
            } else {
                // Send Failure response to the client
                call.respond(
                    HttpStatusCode.BadRequest,
                    NoteResponse(
                        success = false,
                        data = "Failed to Insert Value"
                    )
                )
            }
        }

        get("/notes/{id}") {
            val id: Int = call.parameters["id"]?.toInt() ?: -1
            val note = service.fetchNoteWithId(id)
            if (note == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    NoteResponse(success = false, data = "Could not find note with that id = $id")
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    NoteResponse(success = true, data = note)
                )
            }
        }

        put("/notes/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1
            val updatedNote = call.receive<NoteRequest>()
            val rowsEffected = db.update(NotesEntity) {
                set(it.note, updatedNote.note)
                where {
                    it.id eq id
                }
            }
            if (rowsEffected != 1) {
                call.respond(
                    HttpStatusCode.NotFound,
                    NoteResponse(success = false, data = "Could not find note with that id = $id")
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    NoteResponse(success = true, data = "Success")
                )
            }
        }

        delete("/notes/{id}") {
            val id: Int = call.parameters["id"]?.toInt() ?: -1
            val rowsEffected = service.deleteNote(id)
            if (rowsEffected != 1) {
                call.respond(
                    HttpStatusCode.NotFound,
                    NoteResponse(success = false, data = "Could not find note with that id = $id")
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    NoteResponse(success = true, data = "Success")
                )
            }
        }
    }
}