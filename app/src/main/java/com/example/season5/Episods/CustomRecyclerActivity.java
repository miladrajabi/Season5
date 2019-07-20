package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.season5.R;
import com.example.season5.adapter.CustomRecyclerAdapter;
import com.example.season5.objects.CustomRecyclerObject;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerActivity extends AppCompatActivity {

    RecyclerView rclView;
    List<CustomRecyclerObject> list;
    CustomRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recycler);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {
        rclView = findViewById(R.id.rclView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rclView.setLayoutManager(linearLayoutManager);


        list = prepareData();
        adapter = new CustomRecyclerAdapter(list);
        rclView.setAdapter(adapter);
    }

    private List<CustomRecyclerObject> prepareData() {

        List<CustomRecyclerObject> list = new ArrayList<>();
        CustomRecyclerObject object = new CustomRecyclerObject();

        object.setSongName(getString(R.string.amirAzimi));
        object.setSongName(getString(R.string.amirAzimi_song));
        object.setLike(Integer.parseInt(getString(R.string.amirAzimi_like)));
        object.setView(Integer.parseInt(getString(R.string.amirAzimi_view)));
        object.setDate((getString(R.string.amirAzimi_date)));
        object.setImage(R.drawable.asbevahshi);
        list.add(object);
        return list;
    }
}
