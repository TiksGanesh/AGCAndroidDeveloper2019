package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * XML reference for component show_count
     */
    private TextView showCountTextView;

    /**
     * Counter variable
     */
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Initialise User Interface ---
        showCountTextView = findViewById(R.id.show_count);
    }



    /**
     * Change count and display on TextView showCountTextView
     */
    public void changeCount(View v) {

        // Increment count
        count += 1;

        // Set on Text View
        showCountTextView.setText(String.valueOf(count));
    }

    /**
     * Show Toast
     */
    public void showToast(View v) {
        Toast.makeText(
            this,
            "This is toast.",
            Toast.LENGTH_SHORT
        ).show();
    }
}
