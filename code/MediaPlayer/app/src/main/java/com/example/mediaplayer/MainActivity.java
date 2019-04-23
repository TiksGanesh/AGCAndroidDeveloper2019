package com.example.mediaplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int EXTERNAL_STORAGE_REQUEST_CODE = 8976;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RunTime Permission
        if (checkIfRunTimePermissionRequired()){
            if (!isExternalStoragePermissionAlreadyGranted()){
                requestExternalStoragePermission();
            }else {
                // Do your work
                Toast.makeText(this,"External Storage Permission is already granted", Toast.LENGTH_SHORT).show();
            }
        }else {
            // Do your work
            Toast.makeText(this,"External Storage Permission is not required", Toast.LENGTH_SHORT).show();
        }

        initUI();

    }

    /**
     *
     */
    private void initUI() {
        AppCompatButton playButton = findViewById(R.id.playButton);
        AppCompatButton stopButton = findViewById(R.id.stopButton);

        playButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }


    /**
     * If run time permission required
     * @return true if higher api else false
     */
    private boolean checkIfRunTimePermissionRequired(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * Check if WRITE_EXTERNAL_STORAGE permission is already given.
     * @return true if granted else false
     */
    private boolean isExternalStoragePermissionAlreadyGranted(){
        int permissionStatus = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );

        return PackageManager.PERMISSION_GRANTED == permissionStatus;
    }

    private void requestExternalStoragePermission(){

        ActivityCompat.requestPermissions(
                this,
                new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE },
                EXTERNAL_STORAGE_REQUEST_CODE
        );
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (EXTERNAL_STORAGE_REQUEST_CODE == requestCode
        && grantResults.length > 0
        && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // Do work
            Toast.makeText(this,"External Storage Permission Granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"External Storage Permission Denied", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     *
     * @return
     */
    private String getSongPath(){

        File downloadDir = new File(Environment.getExternalStorageDirectory(),"Download");
        if (downloadDir.exists()){
            File songFile = new File(downloadDir,"song.mp3");
            return songFile.getAbsolutePath();
        }

        return "";
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (R.id.playButton == id){
            try {
                playAudio();
            }catch (IOException ex){
                Log.e("###", "Error Playing Audio", ex);
            }
        }else if (R.id.stopButton == id){
            stopAudio();
        }


    }

    /**
     *
     */
    private void playAudio() throws IOException {

        String path = getSongPath();

        if (!path.isEmpty()){
            Uri songUri = Uri.parse(path);
            mediaPlayer = MediaPlayer.create(this,songUri);

            if (null != mediaPlayer){
                //mediaPlayer.prepare();
                mediaPlayer.start();
            }

            displayToast("Audio Started");

        }else {
            displayToast("Audio File not found");
        }

    }

    /**
     *
     */
    private void stopAudio() {

        if (null != mediaPlayer
        && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        displayToast("Audio Stopped");
    }

    /**
     *
     * @param message
     */
    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
