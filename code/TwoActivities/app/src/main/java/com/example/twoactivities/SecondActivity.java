package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    /**
     * Constant for Intent to send data back to parent activity
     */
    public static final String EXTRA_REPLAY = "com.example.android.twoactivities.extra.REPLY";
    /**
     * LOG TAG constant
     */
    private final static String LOG_TAG = SecondActivity.class.getSimpleName();
    /**
     * Reply Edit Text
     */
    private EditText replyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialise Text Message
        TextView textMessage = findViewById(R.id.text_message);

        // Get Data from Intent
        String extraMessage = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (null != extraMessage) {
            textMessage.setText(extraMessage);
        }

        replyEditText = findViewById(R.id.reply_edittext);
    }

    /**
     * Return reply to Main Activity
     *
     * @param view view object
     */
    public void returnReply(View view) {

        Log.e(LOG_TAG, "Tapped on reply button");

        Intent resultIntent = new Intent();

        String reply = replyEditText.getText().toString();
        if (!reply.isEmpty()) {
            resultIntent.putExtra(EXTRA_REPLAY, reply);
            setResult(RESULT_OK, resultIntent);
        } else {
            setResult(RESULT_CANCELED, null);
        }

        finish();
    }
}
