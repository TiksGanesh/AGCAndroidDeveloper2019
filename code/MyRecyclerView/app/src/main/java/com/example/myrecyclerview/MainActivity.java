package com.example.myrecyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView monthsRecyclerView;

    private MyAdapter myAdapter;

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

                myAdapter.addMonth();
                Snackbar.make(view, "Added new work", Snackbar.LENGTH_LONG)
                        .setAction("Dismiss", null).show();

            }
        });
        initUI();
    }

    /**
     * Initialise User Interface
     */
    private void initUI() {

        List<String> dataSource = createDummyData();

        myAdapter = new MyAdapter(dataSource);

        monthsRecyclerView = findViewById(R.id.monthsRecyclerView);
        monthsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        monthsRecyclerView.setAdapter(myAdapter);
    }

    /**
     * Create Dummy Data
     */
    private List<String> createDummyData() {

        List<String> monthsList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            monthsList.add("Month " + i);
        }
        return monthsList;
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
}
