package com.example.di

import com.example.data.repository.NotesRepository
import com.example.data.service.NotesService
import com.example.data.service.NotesServiceImpl
import org.koin.dsl.module

val notesModule = module {
    single<NotesService> { NotesServiceImpl(get()) } // get() Will resolve NotesRepository
    single { NotesRepository() }
}