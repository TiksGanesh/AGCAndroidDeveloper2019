package com.example.notes.database;

import com.example.notes.pojo.Note;

import androidx.room.Database;
import androidx.room.RoomDatabase;


/**
 * Class:       NoteDatabase
 * Description: Abstract Database Class
 */

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NotesDao dao();
}
