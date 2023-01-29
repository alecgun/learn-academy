package com.example.courseapp.content;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseapp.R;
import com.example.courseapp.model.ContentData;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<ContentData> dataList;

    public void setSearchList(List<ContentData> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public ContentAdapter(Context context, List<ContentData> dataList){
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recImage.setImageResource(dataList.get(position).getDataImage());
        holder.rec_title.setText(dataList.get(position).getDataTitle());
        holder.rec_desc.setText(dataList.get(position).getDataDesc());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView rec_title, rec_desc;
    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        rec_title = itemView.findViewById(R.id.rec_title);
        rec_desc = itemView.findViewById(R.id.rec_desc);
        recCard= itemView.findViewById(R.id.recCard);
    }
}



