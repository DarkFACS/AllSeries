package com.example.allseries.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.allseries.R;
import com.example.allseries.Serie;
import com.example.allseries.SerieActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Serie> mData;

    public RecyclerViewAdapter(Context mContext, List<Serie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_series, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.llcontainer.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));

        holder.tv_serie_title.setText(mData.get(position).getTitle());
        holder.img_serie_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, SerieActivity.class);
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_serie_title;
        ImageView img_serie_thumbnail;
        CardView cardView;
        LinearLayout llcontainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            llcontainer = itemView.findViewById(R.id.ll_container_id);
            tv_serie_title = itemView.findViewById(R.id.serie_title_id);
            img_serie_thumbnail = itemView.findViewById(R.id.serie_img_id);
            cardView = itemView.findViewById(R.id.cardview_id);
        }
    }
}
