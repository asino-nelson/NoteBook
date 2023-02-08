package com.example.notebook.note_features.domainLayer.use_cases

import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }

}