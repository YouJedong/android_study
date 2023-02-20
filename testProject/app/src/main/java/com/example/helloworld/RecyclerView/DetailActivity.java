package com.example.helloworld.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class DetailActivity extends AppCompatActivity {

    TextView detail_title;
    ImageView detail_image;

    String title, url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_detail);

        detail_title = findViewById(R.id.textView_detail);
        detail_image = findViewById(R.id.imageView_detail);

        Intent intent = getIntent();

        title = intent.getExtras().getString("title");
        url = intent.getExtras().getString("url");

        detail_title.setText(title);
        Glide.with(this).load(url).into(detail_image);

    }
}
