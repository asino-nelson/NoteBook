package com.example.notebook.note_features.presentationLayer.note.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.domainLayer.utils.NoteOrder
import com.example.notebook.note_features.domainLayer.utils.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder  = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier.fillMaxWidth()
        ) {
            RadioBtn(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelected = { onOrderChange(NoteOrder.Title(noteOrder.orderType))}
            )
            Spacer(modifier = modifier.width(10.dp))
            RadioBtn(
                text = "Date",
                selected = noteOrder is NoteOrder.Title,
                onSelected = { onOrderChange(NoteOrder.Date(noteOrder.orderType))}
            )
            Spacer(modifier = modifier.width(10.dp))
            RadioBtn(
                    text = "Color",
                    selected = noteOrder is NoteOrder.Title,
                    onSelected = { onOrderChange(NoteOrder.Color(noteOrder.orderType))}
            )
        }
        Spacer(modifier = modifier.height(15.dp))
        Row(
            modifier.fillMaxWidth()
        ) {
            RadioBtn(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelected = { onOrderChange(noteOrder.copy(OrderType.Ascending))}
            )
            Spacer(modifier = modifier.width(10.dp))
            RadioBtn(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelected = { onOrderChange(noteOrder.copy(OrderType.Descending))}
            )

        }

    }
}