package com.example.notebook.note_features.domainLayer.use_cases

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
)
