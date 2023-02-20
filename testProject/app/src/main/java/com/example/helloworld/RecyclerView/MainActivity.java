package com.example.helloworld.RecyclerView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity  extends AppCompatActivity {

    private String[] url = {
            "https://demo.ycart.kr/shopboth_farm_max5_001/data/editor/1612/cd2f39a0598c81712450b871c218164f_1482469221_493.jpg",
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);

        ArrayList<RvItem> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            RvItem rvItem = new RvItem();
            rvItem.title = String.format("Example Title %d", i);
            rvItem.url = url[random.nextInt(url.length)];
            list.add(rvItem) ;
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter adapter = new CustomAdapter(list);
        recyclerView.setAdapter(adapter);
    }




}
