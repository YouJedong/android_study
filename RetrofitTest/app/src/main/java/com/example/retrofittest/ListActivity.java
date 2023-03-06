package com.example.retrofittest;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittest.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListActivity extends AppCompatActivity {

    Call<List<User>> callList;
    TextView textView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        callList = RetrofitClient.getApiService().getList();
        callList.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> result = response.body();
                Log.d("image", "onResponse: " + result.get(1).getThumbnail());
                recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

                ListAdapter adapter = new ListAdapter(result);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });



    }
}
