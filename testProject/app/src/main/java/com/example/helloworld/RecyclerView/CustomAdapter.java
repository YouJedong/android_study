package com.example.helloworld.RecyclerView;

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
import com.example.helloworld.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<RvItem> mData = null;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardView;
        private final TextView textview;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.recycler_view_cardView);
            textview = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    CustomAdapter(ArrayList<RvItem> list) {
        mData = list;
    }


    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recycler_view_row, parent, false) ;
        CustomAdapter.ViewHolder vh = new CustomAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        RvItem rvItem = mData.get(position);

        // 데이터 담기
        Glide.with(holder.itemView.getContext()).load(rvItem.url).into(holder.imageView);
        holder.textview.setText(rvItem.title) ;

        // Detail 이동 이벤트
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();
                Context context = view.getContext();
                Intent detailActivity = new Intent(context, DetailActivity.class);

                detailActivity.putExtra("url", mData.get(mPosition).url);
                detailActivity.putExtra("title", mData.get(mPosition).title);

                ((MainActivity)context).startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }

}
