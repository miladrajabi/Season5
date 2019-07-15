package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.example.season5.R;
import com.example.season5.adapter.spinnerAdapter;
import com.example.season5.objects.spinnerCustomObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<spinnerCustomObject> list = new ArrayList<>();
    spinnerAdapter adapter;
    Spinner spnrOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(this.getClass().getSimpleName());
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        spnrOs = findViewById(R.id.spnrOs);
        list.add(new spinnerCustomObject(R.drawable.android, "android"));
        adapter = new spinnerAdapter(this, android.R.layout.simple_list_item_1, list);
        spnrOs.setAdapter(adapter);
    }
}
