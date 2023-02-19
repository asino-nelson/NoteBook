package com.example.notebook.note_features.presentationLayer.utils

sealed class Screens(val route:String){
    object NoteScreen:Screens("note_screen")
    object AddEditNoteScreen:Screens("add_edit_note_screen")
}
