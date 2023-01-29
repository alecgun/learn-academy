package com.example.courseapp.question;

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

import com.bumptech.glide.Glide;
import com.example.courseapp.R;
import com.example.courseapp.model.QuestionData;

import java.util.List;

public class QAdapter extends RecyclerView.Adapter<QViewHolder> {

    private Context context;
    private List<QuestionData> askList;

    public QAdapter(Context context, List<QuestionData> askList) {
        this.context = context;
        this.askList = askList;
    }

    @NonNull
    @Override
    public QViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QViewHolder holder, int position) {
        Glide.with(context).load(askList.get(position).getDataImageAsk()).into(holder.recImg);
        holder.tvTitle.setText(askList.get(position).getDataTitleAsk());
        holder.tvDesc.setText(askList.get(position).getDataDesceAsk());

        holder.recCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, QDetailActivity.class);
                i.putExtra("image", askList.get(holder.getAdapterPosition()).getDataImageAsk());
                i.putExtra("title", askList.get(holder.getAdapterPosition()).getDataTitleAsk());
                i.putExtra("desc", askList.get(holder.getAdapterPosition()).getDataDesceAsk());
                i.putExtra("key", askList.get(holder.getAdapterPosition()).getKey());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return askList.size();
    }
}

class QViewHolder extends RecyclerView.ViewHolder{

    ImageView recImg;
    TextView tvTitle, tvDesc;
    CardView recCv;

    public QViewHolder(@NonNull View itemView) {
        super(itemView);

        recImg = itemView.findViewById(R.id.item_image);
        tvTitle = itemView.findViewById(R.id.tv_item_title);
        tvDesc = itemView.findViewById(R.id.tv_item_description);
        recCv = itemView.findViewById(R.id.cv_item_question);
    }
}
