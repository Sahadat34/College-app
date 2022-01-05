package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.example.collageapp.R;

public class DepartmentDetailsActivity extends AppCompatActivity {
    WebView dept_details;
    ProgressDialog pd;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        dept_details = findViewById(R.id.department_details);
        WebSettings ws = dept_details.getSettings();
        ws.setJavaScriptEnabled(true);


        String url = getIntent().getStringExtra("url");
        pd = new ProgressDialog(this);
        pd.setTitle("Loading...");
        pd.show();
        dept_details.loadUrl(url);
        pd.dismiss();
    }
}