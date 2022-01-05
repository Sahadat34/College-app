package com.example.collegeapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.example.collegeapp.faculty.TeacherDataAdapter;
import com.example.collegeapp.faculty.TeacherModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Faculty_fragment extends Fragment {
    View view;
    RecyclerView cse_recycler,civil_recycler,mechanical_recycler,electrical_recycler,electronics_recycler;
    LinearLayout cse_noData,civil_noData,mechanical_noData,electrical_noData,electronics_noData;
    public static ArrayList<TeacherModel> cse_list,civil_list,mechanical_list,electrical_list,electronics_list;
    TeacherDataAdapter adapter;
    DatabaseReference reference,dbRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_faculty_fragment, container, false);
        reference = FirebaseDatabase.getInstance().getReference("Faculty");

        cse_recycler = view.findViewById(R.id.cse_recycler);
        civil_recycler = view.findViewById(R.id.civil_recycler);
        mechanical_recycler = view.findViewById(R.id.mechanical_recycler);
        electrical_recycler = view.findViewById(R.id.electrical_recycler);
        electronics_recycler = view.findViewById(R.id.electronics_recycler);

        cse_noData = view.findViewById(R.id.cse_noData);
        civil_noData = view.findViewById(R.id.civil_noData);
        mechanical_noData = view.findViewById(R.id.mechanical_noData);
        electrical_noData = view.findViewById(R.id.electrical_noData);
        electronics_noData = view.findViewById(R.id.electronics_noData);

        mechanicalDepartment();
        electricalDepartment();
        electronicDepartment();
        cseDepartment();
        civilDepartment();

        return view;
    }

    private void electricalDepartment() {
        dbRef = reference.child("ELECTRICAL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                electrical_list = new ArrayList<>();
                if (!snapshot.exists()){
                    electrical_noData.setVisibility(View.VISIBLE);
                    electrical_recycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherModel data = snapshot1.getValue(TeacherModel.class);
                        electrical_list.add(data);
                    }
                    electrical_noData.setVisibility(View.GONE);
                    electrical_recycler.setVisibility(View.VISIBLE);
                    electrical_recycler.setHasFixedSize(true);
                    electrical_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherDataAdapter(electrical_list, getContext());
                    adapter.setHasStableIds(true);
                    electrical_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something error occur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechanicalDepartment() {
        dbRef = reference.child("MECHANICAL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mechanical_list = new ArrayList<>();
                if (!snapshot.exists()){
                    mechanical_recycler.setVisibility(View.GONE);
                    mechanical_noData.setVisibility(View.VISIBLE);
                }else {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherModel data = snapshot1.getValue(TeacherModel.class);
                        mechanical_list.add(data);
                    }
                    mechanical_recycler.setVisibility(View.VISIBLE);
                    mechanical_noData.setVisibility(View.GONE);
                    mechanical_recycler.setHasFixedSize(true);
                    mechanical_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherDataAdapter(mechanical_list, getContext());
                    adapter.setHasStableIds(true);
                    mechanical_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something error occur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cseDepartment() {
        dbRef = reference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cse_list = new ArrayList<>();
                if (!snapshot.exists()){
                    cse_recycler.setVisibility(View.GONE);
                    cse_noData.setVisibility(View.VISIBLE);
                }else {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherModel data = snapshot1.getValue(TeacherModel.class);
                        cse_list.add(data);
                    }
                    cse_recycler.setVisibility(View.VISIBLE);
                    cse_noData.setVisibility(View.GONE);
                    cse_recycler.setHasFixedSize(true);
                    cse_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherDataAdapter(cse_list, getContext());
                    adapter.setHasStableIds(true);
                    cse_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something error occur", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void electronicDepartment() {
        dbRef = reference.child("ELECTRONICS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                electronics_list = new ArrayList<>();
                if (!snapshot.exists()){
                    electronics_noData.setVisibility(View.VISIBLE);
                    electronics_recycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherModel data = snapshot1.getValue(TeacherModel.class);
                        electronics_list.add(data);
                    }
                    electronics_noData.setVisibility(View.GONE);
                    electronics_recycler.setVisibility(View.VISIBLE);
                    electronics_recycler.setHasFixedSize(true);
                    electronics_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherDataAdapter(electronics_list, getContext());
                    adapter.setHasStableIds(true);
                    electronics_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void civilDepartment() {
        dbRef = reference.child("CIVIL");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                civil_list = new ArrayList<>();
                if (!snapshot.exists()){
                    civil_noData.setVisibility(View.VISIBLE);
                    civil_recycler.setVisibility(View.GONE);
                }else {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        TeacherModel data = snapshot1.getValue(TeacherModel.class);
                        civil_list.add(data);
                    }
                    civil_recycler.setVisibility(View.VISIBLE);
                    civil_noData.setVisibility(View.GONE);
                    civil_recycler.setHasFixedSize(true);
                    civil_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherDataAdapter(civil_list, getContext());
                    adapter.setHasStableIds(true);
                    civil_recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something error occur", Toast.LENGTH_SHORT).show();
            }
        });

    }

}