package com.example.collegeapp.notice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.collegeapp.NoticeDetailsActivity;
import com.example.collegeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.myHolder> {
    Context context;
    ArrayList<NoticeModel> list;

    public NoticeAdapter(Context context, ArrayList<NoticeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_feed_layout,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        NoticeModel item = list.get(position);
        holder.notice_title.setText(item.title);
        try {
            Picasso.get().load(item.image).into(holder.notice_image_view);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.time.setText(item.getTime());
        holder.date.setText(item.getDate());
        holder.notice_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NoticeDetailsActivity.class);
                intent.putExtra("imageUrl",item.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class myHolder extends RecyclerView.ViewHolder{
        ImageView notice_image_view;
        TextView notice_title,time,date;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            notice_image_view = itemView.findViewById(R.id.delete_notice_image_view);
            notice_title = itemView.findViewById(R.id.delete_notice_title);
            time = itemView.findViewById(R.id.time_value);
            date = itemView.findViewById(R.id.date_value);
        }
        
    }
}
