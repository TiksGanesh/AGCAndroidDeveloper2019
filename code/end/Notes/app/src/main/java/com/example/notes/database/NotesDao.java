package com.example.notes.database;

import com.example.notes.pojo.Note;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Class:       NotesDao
 * Description: Notes Data Access Object
 */
@Dao
public interface NotesDao {

    @Query("SELECT * from note ORDER BY timestamp DESC")
    List<Note> getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

}
