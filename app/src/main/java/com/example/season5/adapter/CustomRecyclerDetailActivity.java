package com.example.season5.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.season5.R;
import com.example.season5.objects.CustomRecyclerObject;

public class CustomRecyclerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_recyclerview_row);


        CustomRecyclerObject object = (CustomRecyclerObject) getIntent().getSerializableExtra("object");
        setTitle(object.getSongName());
    }
}
