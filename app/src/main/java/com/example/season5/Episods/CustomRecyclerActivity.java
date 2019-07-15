package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        list = prepareData();
        adapter = new CustomRecyclerAdapter();
        rclView.setAdapter(adapter);
    }

    private ArrayList<CustomRecyclerObject> prepareData() {


        return null;
    }
}
