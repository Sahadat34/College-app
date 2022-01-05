package com.example.collegeapp.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.NoticeDetailsActivity;
import com.example.collegeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyHolder> {
    Context context;
    List<String> image;

    public GalleryAdapter(Context context, List<String> image) {
        this.context = context;
        this.image = image;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image_view,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        try{
            Picasso.get().load(image.get(position)).into(holder.imageView);
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, NoticeDetailsActivity.class);
                intent.putExtra("imageUrl",image.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView  = itemView.findViewById(R.id.galleryImageView);
        }
    }
}
