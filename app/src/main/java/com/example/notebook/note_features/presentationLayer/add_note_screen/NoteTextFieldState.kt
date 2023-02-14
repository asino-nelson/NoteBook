package com.example.notebook.note_features.presentationLayer.add_note_screen

data class NoteTextFieldState (
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)