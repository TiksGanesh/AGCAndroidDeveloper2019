package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {

    private static final String MIME_TYPE = "text/plain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Open Website
     *
     * @param view view object
     */
    public void openWebSite(View view) {

        // Get Data from EditText
        EditText urlEditText = findViewById(R.id.urlEditText);
        String url = urlEditText.getText().toString();
        if (!url.isEmpty()) {
            Uri webUri = Uri.parse(url);
            Intent webSiteIntent = new Intent(Intent.ACTION_VIEW, webUri);
            if (webSiteIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webSiteIntent);
            } else {
                showNoApplicationToast();
            }
        } else {
            showErrorToast("Please Enter Website URL");
        }

    }

    /**
     * Share Data with Other application
     *
     * @param view view object
     */
    public void shareData(View view) {

        // Get Data from EditText
        EditText shareDataEditText = findViewById(R.id.shareDataEditText);
        String shareData = shareDataEditText.getText().toString();

        if (!shareData.isEmpty()) {

            ShareCompat.IntentBuilder
                .from(this)
                .setType(MIME_TYPE)
                .setChooserTitle(getString(R.string.share_data_edittext))
                .setText(shareData)
                .startChooser();

        } else {
            showErrorToast("Please Enter Some Text To Share");
        }
    }

    /**
     * Open location with Map application
     *
     * @param view view object
     */
    public void openLocation(View view) {

        // Get Data from EditText
        EditText locationEditText = findViewById(R.id.locationEditText);
        String location = locationEditText.getText().toString();
        if (!location.isEmpty()) {
            Uri locationUri = Uri.parse("geo:0,0?q=" + location);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                showNoApplicationToast();
            }
        } else {
            showErrorToast("Please Enter Location");
        }
    }

    /**
     * Show No application found Toast
     */
    private void showNoApplicationToast() {
        Toast.makeText(this,
            "No application found",
            Toast.LENGTH_SHORT).show();
    }

    /**
     * Show No application found Toast
     */
    private void showErrorToast(String toastMessage) {
        Toast.makeText(this,
            toastMessage,
            Toast.LENGTH_SHORT).show();
    }


}
