package com.example.collegeapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.example.collegeapp.notice.NoticeAdapter;
import com.example.collegeapp.notice.NoticeModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Notice_fragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    ArrayList<NoticeModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_notice_fragment, container, false);
        recyclerView = view.findViewById(R.id.notice_recycler);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Notice");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()){
                    Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
                }
                list = new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    NoticeModel data = snapshot1.getValue(NoticeModel.class);
                    list.add(data);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setHasFixedSize(true);
                NoticeAdapter adapter = new NoticeAdapter(getContext(),list);
                adapter.setHasStableIds(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;

    }
}