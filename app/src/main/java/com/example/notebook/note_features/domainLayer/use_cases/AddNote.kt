package com.example.notebook.note_features.domainLayer.use_cases

import com.example.notebook.note_features.domainLayer.model.InvalidNoteException
import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("Note title cannot be empty !!")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("Note content cannot be empty !!")
        }
        repository.insertNote(note)
    }
}