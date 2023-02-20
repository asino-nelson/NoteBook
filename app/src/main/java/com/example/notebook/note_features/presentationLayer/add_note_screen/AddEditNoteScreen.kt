package com.example.notebook.note_features.presentationLayer.add_note_screen


import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notebook.note_features.domainLayer.model.Note
import com.example.notebook.note_features.presentationLayer.add_note_screen.components.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.compose.material3.SnackbarHost as SnackbarHost1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(
    navController:NavController,
    noteColor: Int,
    viewModel: AddEditNoteViewModel = hiltViewModel()
){
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value

    val noteBackgroundAnimation = remember {
        Animatable(
            Color(
                if (noteColor != -1) {
                    noteColor
                } else viewModel.noteColor.value
            )
        )
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true ){
        viewModel.eventFlow.collectLatest { event ->
            when (event){
                is AddEditNoteViewModel.UiEvent.ShowSnackBar -> {

                }
                is AddEditNoteViewModel.UiEvent.SaveNote-> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.onEvent(AddEditNoteEvent.SaveMyNote)},
            containerColor = MaterialTheme.colorScheme.primary)
            {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Save Note")
            }
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(noteBackgroundAnimation.value)
                .padding(20.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Note.noteColors.forEach { color ->
                    val colorInt = color.toArgb()
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color)
                            .border(
                                width = 3.dp,
                                color = if (viewModel.noteColor.value == colorInt) {
                                    Color.Black
                                } else Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable {
                                scope.launch {
                                    noteBackgroundAnimation.animateTo(
                                        targetValue = Color(colorInt),
                                        animationSpec = tween(
                                            durationMillis = 500
                                        )
                                    )
                                }
                                viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange ={
                               viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                } ,
                onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                textStyle = MaterialTheme.typography.titleMedium,
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))
            TransparentHintTextField(
                text = contentState.text,
                hint = contentState.hint,
                onValueChange ={
                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
                } ,
                onFocusChange = {
                    viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it))
                },
                isHintVisible = contentState.isHintVisible,
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxHeight()
            )
        }
    }

}