package com.example.collegeapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class PdfActivity extends AppCompatActivity {
    ArrayList<PdfModel> list;
    DatabaseReference databaseReference;
    RecyclerView pdfRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfRecycler = findViewById(R.id.pdf_activity_recycler);
        pdfRecycler.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference("pdf");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()){
                    Toast.makeText(PdfActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
                list = new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    PdfModel model = snapshot1.getValue(PdfModel.class);
                    list.add(model);
                }
                EbookAdapter adapter = new EbookAdapter(PdfActivity.this,list);
                adapter.setHasStableIds(true);
                pdfRecycler.setLayoutManager(new LinearLayoutManager(PdfActivity.this));
                pdfRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(PdfActivity.this, "Can't Connect to the Database", Toast.LENGTH_SHORT).show();
            }
        });
    }
}