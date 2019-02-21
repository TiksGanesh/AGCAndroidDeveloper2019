package com.example.implicitintentreceiver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Data From Intent
        Intent intent = getIntent();

        // Get Uri
        Uri uri = intent.getData();

        if (null != uri) {
            String webURL = uri.toString();
            showWebURLinWebView(webURL);
        }else  {
            showWebURLinWebView("https://www.quora.com/");
        }
    }

    /**
     * Show Received Web URL in Web View
     *
     * @param webURL String web url
     */
    private void showWebURLinWebView(String webURL) {

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl(webURL);
    }


    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}
