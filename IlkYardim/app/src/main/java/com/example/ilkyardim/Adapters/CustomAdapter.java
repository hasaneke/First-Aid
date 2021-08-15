package com.example.ilkyardim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ilkyardim.Model.Aid;
import com.example.ilkyardim.R;
import com.example.ilkyardim.Views.DetailActivity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Aid> aidList;

    public CustomAdapter(Context context, ArrayList<Aid> aidList){
        this.context = context;
        this.aidList = aidList;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_view,parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        holder.aidText.setText(aidList.get(position).getAidName());
        //holder.aidImage.setImageResource(aidList.get(position).getImageInt());
        Picasso.get()
                .load(aidList.get(position).getImageInt())
                .resize(500,500)
                .centerCrop()
                .into(holder.aidImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Object",aidList.get(position));
                intent.putExtra("Position",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return aidList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView aidText;
        ImageView aidImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            aidText = itemView.findViewById(R.id.textView);
            aidImage = itemView.findViewById(R.id.imageView);
        }
    }
}
