package com.example.season5.Episods;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.season5.R;
import com.example.season5.adapter.CustomRecyclerAdapter;
import com.example.season5.adapter.CustomRecyclerDetailActivity;
import com.example.season5.app.app;
import com.example.season5.interfaces.CustomRecyclerViewClickListener;
import com.example.season5.objects.CustomListViewObject;
import com.example.season5.objects.CustomRecyclerObject;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerActivity extends AppCompatActivity implements View.OnClickListener, CustomRecyclerViewClickListener {

    RecyclerView rclView;
    List<CustomRecyclerObject> list;
    CustomRecyclerAdapter adapter;
    FloatingActionButton fabRcl;
    public static final int LAYOUT_MANAGER_LINEAR = 1;
    public static final int LAYOUT_MANAGER_GRID = 2;

    int layoutManager = LAYOUT_MANAGER_LINEAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recycler);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {
        rclView = findViewById(R.id.rclView);
        fabRcl = findViewById(R.id.fabRcl);
        fabRcl.setOnClickListener(this);
        setLayoutManager(layoutManager);


        list = prepareData();
        adapter = new CustomRecyclerAdapter(list, this);
        rclView.setAdapter(adapter);
    }

    private List<CustomRecyclerObject> prepareData() {

        List<CustomRecyclerObject> list = new ArrayList<>();
        CustomRecyclerObject object = new CustomRecyclerObject();

        object.setSingerName(getString(R.string.amirAzimi));
        object.setSongName(getString(R.string.amirAzimi_song));
        object.setLike(Integer.parseInt(getString(R.string.amirAzimi_like)));
        object.setView(Integer.parseInt(getString(R.string.amirAzimi_view)));
        object.setDate((getString(R.string.amirAzimi_date)));
        object.setImage(R.drawable.asbevahshi);
        list.add(object);

        object = new CustomRecyclerObject();

        object.setSingerName(getString(R.string.krypton));
        object.setSongName(getString(R.string.amirAzimi_song));
        object.setLike(Integer.parseInt(getString(R.string.amirAzimi_like)));
        object.setView(Integer.parseInt(getString(R.string.amirAzimi_view)));
        object.setDate((getString(R.string.amirAzimi_date)));
        object.setImage(R.drawable.kryptons);

        list.add(object);
        return list;
    }

    private void setLayoutManager(int linear) {

        if (linear == 1) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rclView.setLayoutManager(linearLayoutManager);
            fabRcl.setImageResource(R.drawable.ic_dehaze_black_24dp);
        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            rclView.setLayoutManager(gridLayoutManager);
            fabRcl.setImageResource(R.drawable.ic_grid_on_black_24dp);

        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fabRcl) {
            if (layoutManager == LAYOUT_MANAGER_LINEAR) {
                layoutManager = LAYOUT_MANAGER_GRID;
            } else {
                layoutManager = LAYOUT_MANAGER_LINEAR;
            }
            setLayoutManager(layoutManager);
        }
    }

    @Override
    public void OnClick(CustomRecyclerObject object) {

        Intent intent = new Intent(this, CustomRecyclerDetailActivity.class);
        intent.putExtra("object", object);
        startActivity(intent);

    }
}
