package com.example.notebook.note_features.dataLayer.repository

import com.example.notebook.note_features.dataLayer.data_source.NoteDao
import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}