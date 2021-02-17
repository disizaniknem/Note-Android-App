package com.disizaniknem.ktornoteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.disizaniknem.ktornoteapp.data.local.entities.LocallyDeletedNoteId
import com.disizaniknem.ktornoteapp.data.local.entities.Note

@Database(
    entities = [
        Note::class,
        LocallyDeletedNoteId::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}