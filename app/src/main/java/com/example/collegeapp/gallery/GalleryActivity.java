package com.example.collegeapp.gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    RecyclerView convo,fest,treePlantation;
    TextView convo_seeAll,fest_seeAll,treePlantation_seeAll;
    DatabaseReference reference,dbref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");
        convo = findViewById(R.id.convocation_recycler);
        fest = findViewById(R.id.fest_recycler);
        treePlantation = findViewById(R.id.tree_plantation_recycler);

        convo_seeAll = findViewById(R.id.convocation_seeAll);
        fest_seeAll = findViewById(R.id.fest_seeAll);
        treePlantation_seeAll = findViewById(R.id.tree_plantation_seeAll);

        convoRecyclerImage();
        festRecyclerImage();
        treePlantationRecyclerImage();

        convo_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String child = "Convocation";
                getallImage(child);
            }
        });
        fest_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String child = "Fest";
                getallImage(child);
            }
        });
        treePlantation_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String child = "Tree plantation";
                getallImage(child);
            }
        });
    }

    private void festRecyclerImage() {

        dbref = reference.child("Fest");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> imageUrl = new ArrayList<>();
                if (!snapshot.exists()) {
                    Toast.makeText(GalleryActivity.this, "Image not Found", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        String data = (String) snapshot1.getValue();
                        imageUrl.add(data);
                    }
                }
                if (imageUrl.size()>5){
                    List<String> newList = new ArrayList<>();
                    for (int i = 0;i<=5;i++){
                        newList.add(imageUrl.get(i));
                    }
                    GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,newList);
                    adapter.setHasStableIds(true);
                    treePlantation.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                    treePlantation.setAdapter(adapter);
                }
                GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,imageUrl);
                adapter.setHasStableIds(true);
                treePlantation.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                treePlantation.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void treePlantationRecyclerImage() {

        dbref = reference.child("Tree plantation");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> imageUrl = new ArrayList<>();
                if (!snapshot.exists()) {
                    Toast.makeText(GalleryActivity.this, "Image not Found", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        String data = (String) snapshot1.getValue();
                        imageUrl.add(data);
                    }
                }
                if (imageUrl.size()>5){
                    List<String> newList = new ArrayList<>();
                    for (int i = 0;i<=5;i++){
                        newList.add(imageUrl.get(i));
                    }
                    GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,newList);
                    adapter.setHasStableIds(true);
                    fest.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                    fest.setAdapter(adapter);
                }
                GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,imageUrl);
                adapter.setHasStableIds(true);
                fest.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                fest.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void convoRecyclerImage() {
        dbref = reference.child("Convocation");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> imageUrl = new ArrayList<>();
                if (!snapshot.exists()) {
                    Toast.makeText(GalleryActivity.this, "Image not Found", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                        String data = (String) snapshot1.getValue();
                        imageUrl.add(data);
                    }
                }
                if (imageUrl.size()>5){
                    List<String> newList = new ArrayList<>();
                    for (int i = 0;i<=5;i++){
                        newList.add(imageUrl.get(i));
                    }
                    GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,newList);
                    adapter.setHasStableIds(true);
                    convo.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                    convo.setAdapter(adapter);
                }
                GalleryAdapter adapter = new GalleryAdapter(GalleryActivity.this,imageUrl);
                adapter.setHasStableIds(true);
                convo.setLayoutManager(new LinearLayoutManager(GalleryActivity.this,LinearLayoutManager.HORIZONTAL,true));
                convo.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void getallImage(String child) {
        Intent intent = new Intent(GalleryActivity.this,AllImage.class);
        intent.putExtra("child",child);
        startActivity(intent);
    }
}