package com.example.collegeapp.ebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;

import java.util.ArrayList;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.myHolder> {
    private Context context;
    ArrayList<PdfModel> list;

    public EbookAdapter(Context context, ArrayList<PdfModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pdf_layout,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        PdfModel item = list.get(position);
        holder.pdfTitle.setText(item.getPdfTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PdfViewActivity.class);
                intent.putExtra("pdfUrl",item.getPdfUrl());
                context.startActivity(intent);
            }
        });
        holder.pdf_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(item.getPdfUrl()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        TextView pdfTitle;
        ImageView pdf_download;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            pdfTitle = itemView.findViewById(R.id.pdf_view_title);
            pdf_download = itemView.findViewById(R.id.pdf_download_img);
        }
    }
}
