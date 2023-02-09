package com.example.notebook.di

import android.app.Application
import androidx.room.Room
import com.example.notebook.note_features.dataLayer.data_source.NoteDatabase
import com.example.notebook.note_features.dataLayer.repository.NoteRepositoryImpl
import com.example.notebook.note_features.domainLayer.repository.NoteRepository
import com.example.notebook.note_features.domainLayer.use_cases.AddNote
import com.example.notebook.note_features.domainLayer.use_cases.DeleteNote
import com.example.notebook.note_features.domainLayer.use_cases.GetNotes
import com.example.notebook.note_features.domainLayer.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}