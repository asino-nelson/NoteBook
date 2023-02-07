package com.example.notebook.note_features.dataLayer.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notebook.note_features.domainLayer.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao
}