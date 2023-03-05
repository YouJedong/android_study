package com.example.roomtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.roomtest.DAO.UserDao;
import com.example.roomtest.DB.AppDatabase;
import com.example.roomtest.VO.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListActivity extends AppCompatActivity {

    AppDatabase db;
    UserDao userDao;
    Handler handler;

    private String[] url = {
            "https://t1.daumcdn.net/cfile/tistory/24283C3858F778CA2E",
            "https://www.codingfactory.net/wp-content/uploads/abc.jpg",
            "https://source.unsplash.com/random",
            "https://picsum.photos/250/250",
            "https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg",
            "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-after-qa1.png",
            "https://www.urbanbrush.net/en/wp-content/uploads/edd/2022/11/urbanbrush-20221112181833147836.jpg",
            "https://static.news.zumst.com/images/36/2020/09/29/9a2dbdaab03441a99e1cfab6ffaaa408.jpg",
            "https://cdn.aitimes.com/news/photo/202204/143854_149286_5624.png"
    };

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ExecutorService es = Executors.newSingleThreadExecutor();
        db = AppDatabase.getAppDatabase(ListActivity.this);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Bundle bd = msg.getData();
                List<User> list = (List<User>) bd.getSerializable("List");
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));

                ListAdapter adapter = new ListAdapter(list);
                recyclerView.setAdapter(adapter);
            }
        };

        es.execute(() -> {
            List<User> list = db.userDao().getAll();

            Message msg = handler.obtainMessage();
            Bundle bd = new Bundle();
            bd.putSerializable("List", (Serializable) list);
            msg.setData(bd);

            handler.sendMessage(msg);
        });








    }


}
