package com.example.notebook.note_features.presentationLayer.note.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RadioBtn(
    text:String,
    selected:Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = selected,
            onClick = onSelected,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier.width(10.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}