package com.example.notes;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.notes.database.DatabaseManager;
import com.example.notes.pojo.Note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;

public class AddNoteActivity extends AppCompatActivity {


    private AppCompatEditText noteDescriptionET;
    private AppCompatEditText noteTitleET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initUI();

    }

    private void initUI() {
        noteTitleET = findViewById(R.id.noteTitleEditText);
        noteDescriptionET = findViewById(R.id.noteDescriptionEditText);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (android.R.id.home == id) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveNote(View view) {

        String title = noteTitleET.getText().toString().trim();
        if (title.isEmpty()) {
            showError("Please add note title");
            return;
        }

        String description = noteDescriptionET.getText().toString().trim();
        if (description.isEmpty()) {
            showError("Please add note description");
            return;
        }

        new SaveTask(title, description).execute();
    }

    private void showError(String message) {
        Toast.makeText(this,
                message,
                Toast.LENGTH_SHORT).show();
    }


    class SaveTask extends AsyncTask<Void, Void, Void> {

        private String title;
        private String description;


        public SaveTask(String title, String description) {
            this.title = title;
            this.description = description;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Note note = new Note();
            note.setNoteTitle(title);
            note.setNoteDescription(description);
            note.setNoteTimeStamp("" + System.currentTimeMillis());

            DatabaseManager.getInstance(getApplicationContext())
                    .getNoteDatabase()
                    .dao()
                    .insertNote(note);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            showError("Note Saved");
            finish();
        }
    }
}
