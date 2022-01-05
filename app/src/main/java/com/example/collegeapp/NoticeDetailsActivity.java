package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.collageapp.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class NoticeDetailsActivity extends AppCompatActivity {
    PhotoView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);
        Objects.requireNonNull(getSupportActionBar()).hide();
        photoView = findViewById(R.id.noticeFullImage);
        String imageUrl = getIntent().getStringExtra("imageUrl");

        Picasso.get().load(imageUrl).into(photoView);
    }
}