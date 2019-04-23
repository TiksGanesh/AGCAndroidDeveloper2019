package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup colorGroup;
    private View parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     *
     */
    private void initUI() {

        colorGroup  = findViewById(R.id.colorGroup);
        parentView = findViewById(R.id.parentView);
        AppCompatButton applyButton = findViewById(R.id.applyButton);
        applyButton.setOnClickListener(this);

        // Check if  background color is already set
        int color = ApplicationPreference.getBackgroundColor(this);
        parentView.setBackgroundColor(color);
        //TODO: Set Checked Radio Button as per color previously selected
    }

    @Override
    public void onClick(View v) {


        int selectedRadioButtonId = colorGroup.getCheckedRadioButtonId();

        if (R.id.colorGreen == selectedRadioButtonId){
            parentView.setBackgroundColor(Color.GREEN);
            ApplicationPreference.storeBackgroundColor(this,Color.GREEN);
        }else if (R.id.colorRed == selectedRadioButtonId){
            parentView.setBackgroundColor(Color.RED);
            ApplicationPreference.storeBackgroundColor(this,Color.RED);
        }else if (R.id.colorWhite == selectedRadioButtonId){
            parentView.setBackgroundColor(Color.WHITE);
            ApplicationPreference.storeBackgroundColor(this,Color.WHITE);
        }else {
            Toast.makeText(this, "Please choose background color",Toast.LENGTH_SHORT).show();
        }

    }
}
