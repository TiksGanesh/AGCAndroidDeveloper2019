package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

public class ApplicationPreference {

    private final static String FILE_NAME = "com.example.sharedpreferences.appcolor";

    //--KEYS --
    private final static String BACKGROUND_COLOR = "background_color";


    public static void storeBackgroundColor(Context context, int color){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(BACKGROUND_COLOR,color);
        editor.apply();
    }


    public static int getBackgroundColor(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        if (sharedPreferences.contains(BACKGROUND_COLOR)){
            return sharedPreferences.getInt(BACKGROUND_COLOR, Color.WHITE);
        }
        return Color.WHITE;
    }
}
