package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * Key for intent to pass data
     */
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    /**
     * Log constant
     */
    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    /**
     * Request Code for Intent
     */
    private final static Integer REQUEST_CODE = 9922;
    /**
     * message edit text
     */
    private EditText messageEditText;
    /**
     * Reply Message
     */
    private TextView replyHeaderTextView;
    private TextView replyMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = findViewById(R.id.message_edittext);
        replyMessageTextView = findViewById(R.id.text_message_reply);
        replyHeaderTextView = findViewById(R.id.text_header_reply);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RESULT_OK == resultCode
            && REQUEST_CODE == requestCode
            && null != data) {
            replyHeaderTextView.setVisibility(View.VISIBLE);
            replyMessageTextView.setVisibility(View.VISIBLE);

            String replyMessage = data.getStringExtra(SecondActivity.EXTRA_REPLAY);
            replyMessageTextView.setText(replyMessage);
        }
    }

    /**
     * OnClick function for send button
     *
     * @param view view object
     */
    public void launchSecondActivity(View view) {

        Log.e(LOG_TAG, "Tapped on send button");

        Intent intent = new Intent(this, SecondActivity.class);

        // Get Data from EditText
        if (null != messageEditText) {
            String extraMessage = messageEditText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, extraMessage);
        }

        startActivityForResult(intent, REQUEST_CODE);
    }
}
