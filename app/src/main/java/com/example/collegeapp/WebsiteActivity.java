package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.collegeapp.R;

public class WebsiteActivity extends AppCompatActivity {
    String webUrl = "https://bitm.org.in/";
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        WebView mywebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl(webUrl);

    }
}