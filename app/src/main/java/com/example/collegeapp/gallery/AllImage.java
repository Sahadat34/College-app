package com.example.collegeapp.gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllImage extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference,dbref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_image);
        reference = FirebaseDatabase.getInstance().getReference("Gallery");

        recyclerView = findViewById(R.id.all_image_recycler);

        String child = getIntent().getStringExtra("child");
        dbref = reference.child(child);
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> allImage = new ArrayList<>();
                if(!snapshot.exists()){
                    Toast.makeText(AllImage.this, "No Image found", Toast.LENGTH_SHORT).show();
                }
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    allImage.add(data);
                }
                GalleryAdapter adapter = new GalleryAdapter(AllImage.this,allImage);
                adapter.setHasStableIds(true);
                recyclerView.setLayoutManager(new GridLayoutManager(AllImage.this,2));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}