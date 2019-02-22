package com.example.mycafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {


    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Spinner spinnerQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpSpinner();
    }

    private void setUpSpinner() {

        spinnerQuantity = findViewById(R.id.spinnerQuantity);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.quantity_array,
            android.R.layout.simple_spinner_item);

        if (null != spinnerQuantity) {
            spinnerQuantity.setAdapter(adapter);
            spinnerQuantity.setOnItemSelectedListener(this);
        }

    }

    /**
     * Place order button click
     *
     * @param view view object
     */
    public void placeOrder(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedQuantity = parent.getItemAtPosition(position).toString();
        Log.e(LOG_TAG, "Selected Quantity: " + selectedQuantity);
        if (position > 0) {
            displayToast("Selected Quantity: " + selectedQuantity);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.e(LOG_TAG, "Nothing Selected");
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
