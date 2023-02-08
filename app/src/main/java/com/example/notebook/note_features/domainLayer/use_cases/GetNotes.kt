package com.example.notebook.note_features.domainLayer.use_cases

import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.repository.NoteRepository
import com.example.notebook.note_features.domainLayer.utils.NoteOrder
import com.example.notebook.note_features.domainLayer.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>>{

        return repository.getAllNotes().map { notes ->
            when (noteOrder.orderType){
                is OrderType.Ascending -> {
                    when (noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}