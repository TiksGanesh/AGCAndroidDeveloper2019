package com.example.notes.database;

import android.content.Context;

import androidx.room.Room;

/**
 * Class:       DatabaseManager
 * Description: Database Manager class
 */
public class DatabaseManager {

    /**
     * Static object
     */
    private static DatabaseManager databaseManager;
    /**
     * Abstract Database object
     */
    private NoteDatabase noteDatabase;

    private DatabaseManager(Context context) {
        // Do something
        noteDatabase = Room.databaseBuilder(context,
                NoteDatabase.class,
                "MyNotes").build();
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        if (null == databaseManager) {
            databaseManager = new DatabaseManager(context);
        }

        return databaseManager;
    }


    public NoteDatabase getNoteDatabase() {
        return noteDatabase;
    }
}
