package com.example.notes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.notes.database.DatabaseManager;
import com.example.notes.pojo.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToAddNote();
            }
        });


        //
        setUpRecyclerView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getNotes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Set Up RecyclerView
     */

    private void setUpRecyclerView() {
        RecyclerView noteRecyclerView = findViewById(R.id.notesRecyclerView);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false));
        // Set Adapter
        adapter = new NotesAdapter();
        noteRecyclerView.setAdapter(adapter);
        //mockData();
        getNotes();
    }

    /**
     * Get Notes from Database
     */
    private void getNotes() {
        new NotesTask().execute();
    }

    /**
     * Mock note data
     */
    private void mockData() {
//        String timeStamp = "15 Apr 2019 12:31";
//        String description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.";
//        String title = "Grocery List";
//
//        Note mockModel = new Note(1, title, description, timeStamp);
//        List<Note> mockList = new ArrayList<>();
//        mockList.add(mockModel);
//        adapter.updateNotes(mockList);
    }

    /**
     * Navigate to add note activity
     */
    private void navigateToAddNote() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    /**
     * Navigate To Detail Activity
     */
    private void navigateToDetail() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

    class NotesTask extends AsyncTask<Void, Void, List<Note>> {

        @Override
        protected List<Note> doInBackground(Void... voids) {

            return DatabaseManager.getInstance(getApplicationContext())
                    .getNoteDatabase()
                    .dao()
                    .getAllNotes();
        }

        @Override
        protected void onPostExecute(List<Note> notes) {
            super.onPostExecute(notes);
            adapter.updateNotes(notes);
        }
    }
}
