package com.example.notebook.note_features.presentationLayer.add_note_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.notebook.note_features.domainLayer.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
):ViewModel(){

    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle
}