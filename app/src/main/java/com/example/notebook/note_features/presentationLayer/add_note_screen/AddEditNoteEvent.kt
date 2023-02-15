package com.example.notebook.note_features.presentationLayer.add_note_screen

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value:String):AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState):AddEditNoteEvent()

    data class EnteredContent(val value:String):AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState):AddEditNoteEvent()

    data class ChangeColor(val color:Int):AddEditNoteEvent()

    object SaveMyNote: AddEditNoteEvent()

}
