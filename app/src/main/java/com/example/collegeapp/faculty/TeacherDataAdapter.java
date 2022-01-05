package com.example.collegeapp.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeacherDataAdapter extends RecyclerView.Adapter<TeacherDataAdapter.Myholder> {
   ArrayList<TeacherModel> teacherModels;
   Context context;

    public TeacherDataAdapter(ArrayList<TeacherModel> teacherModels, Context context) {
        this.teacherModels = teacherModels;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myholder(LayoutInflater.from(context).inflate(R.layout.faculty_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        TeacherModel item = teacherModels.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.position.setText(item.getPosition());
        try {
            Picasso.get().load(item.getImage()).into(holder.profileImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return teacherModels.size();
    }


    public class Myholder extends RecyclerView.ViewHolder {
        TextView name,email,position;
        Button teacherDataUpdate_btn;
        ImageView profileImage;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacher_name);
            email = itemView.findViewById(R.id.teacher_email);
            position = itemView.findViewById(R.id.teacher_position);
            profileImage = itemView.findViewById(R.id.teacher_profile_photo);
        }
    }
}
