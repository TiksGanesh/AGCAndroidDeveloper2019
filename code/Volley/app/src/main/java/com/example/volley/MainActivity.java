package com.example.volley;

import android.os.Bundle;

import com.android.volley.VolleyError;
import com.example.volley.core.RequestContract;
import com.example.volley.core.ResponseInterface;
import com.example.volley.model.ContactsItem;
import com.example.volley.utility.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ResponseInterface.OnContactResponseListener {

    /**
     * LOG TAG
     */
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * Request Contract Object
     */
    private RequestContract requestContract;

    private TextView resultTextView;

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
                if (Utils.isInternetConnectivity(MainActivity.this)){
                    requestContract.getContactsFromServer(LOG_TAG, MainActivity.this);
                }else  {
                    showErrorToast("Please check if Internet is connected");
                }
            }
        });

        resultTextView = findViewById(R.id.resultTextView);

        initNetwork();
    }

    private void initNetwork() {
        requestContract = RequestContract.getRequestContract();
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

    @Override
    public void onContactResponse(boolean isSuccess, List<ContactsItem> contactsItemList, VolleyError error) {
        if (isSuccess){
            //resultTextView.setText(response);
            Log.e(LOG_TAG, contactsItemList.get(3).toString());
        }else {
            showErrorToast(error.getLocalizedMessage());
        }
    }

    /**
     * Show Error Toast
     * @param localizedMessage  error message
     */
    private void showErrorToast(String localizedMessage) {
        Toast.makeText(this,
                localizedMessage,
                Toast.LENGTH_LONG).show();
    }
}
