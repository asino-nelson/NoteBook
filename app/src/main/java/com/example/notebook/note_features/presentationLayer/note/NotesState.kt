package com.example.notebook.note_features.presentationLayer.note

import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.utils.NoteOrder
import com.example.notebook.note_features.domainLayer.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
