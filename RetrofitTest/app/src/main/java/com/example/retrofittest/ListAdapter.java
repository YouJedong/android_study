package com.example.retrofittest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofittest.Model.User;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<User> mData = null;
    ListAdapter(List<User> list) {mData = list;}

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView textView;
        private final ImageView imageView;


        public ViewHolder(@NonNull View view) {
            super(view);
            cardView = view.findViewById(R.id.card_view);
            textView = view.findViewById(R.id.text_view);
            imageView = view.findViewById(R.id.image_view);
        }
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);
        ListAdapter.ViewHolder vh = new ListAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        User user = mData.get(position);

        holder.textView.setText("Volnum : " + user.getVolnum());
        Glide.with(holder.imageView.getContext()).load(user.getThumbnail()).circleCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
