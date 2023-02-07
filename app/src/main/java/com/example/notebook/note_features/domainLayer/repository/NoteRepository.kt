package com.example.notebook.note_features.domainLayer.repository


import com.example.notebook.note_features.domainLayer.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id:Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}