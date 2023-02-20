package com.example.notebook.note_features.presentationLayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notebook.note_features.presentationLayer.add_note_screen.AddEditNoteScreen
import com.example.notebook.note_features.presentationLayer.note.NoteScreen
import com.example.notebook.note_features.presentationLayer.utils.Screens
import com.example.notebook.ui.theme.NoteBookTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteBookTheme {
               Surface (
                   color = MaterialTheme.colorScheme.background
               ){
                   val navController = rememberNavController()
                   NavHost(
                       navController = navController ,
                       startDestination = Screens.NoteScreen.route
                   ){
                       composable(route = Screens.NoteScreen.route){
                           NoteScreen(navController = navController)
                       }
                       composable(
                           route = Screens.AddEditNoteScreen.route +
                               "?noteId={noteId}&noteColor={noteColor}",
                           arguments = listOf(
                               navArgument(
                                   name = "noteId"
                               ){
                                   type = NavType.IntType
                                   defaultValue = -1
                               },
                               navArgument(
                                   name = "noteColor"
                               ){
                                   type = NavType.IntType
                                   defaultValue = -1
                               }
                           )

                       ){
                           val color = it.arguments?.getInt("noteColor") ?: -1
                           AddEditNoteScreen(
                               navController = navController,
                               noteColor = color
                           )
                       }
                   }
               }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteBookTheme {

    }
}