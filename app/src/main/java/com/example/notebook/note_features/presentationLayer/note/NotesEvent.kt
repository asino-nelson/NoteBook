package com.example.notebook.note_features.presentationLayer.note

import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.utils.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
