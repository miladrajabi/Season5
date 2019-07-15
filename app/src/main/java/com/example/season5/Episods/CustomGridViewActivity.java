package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.season5.R;
import com.example.season5.adapter.CustomGridViewAdapter;
import com.example.season5.objects.CustomListViewObject;

import java.util.ArrayList;
import java.util.List;

public class CustomGridViewActivity extends AppCompatActivity {

    GridView grdView;
    List<CustomListViewObject> list;
    CustomGridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        grdView = findViewById(R.id.grdView);

        list = prepareData();
        adapter = new CustomGridViewAdapter(this, 0, list);
        grdView.setAdapter(adapter);

    }

    private List<CustomListViewObject> prepareData() {

        List<CustomListViewObject> list = new ArrayList<>();
        CustomListViewObject object = new CustomListViewObject();
        object.setSubjectName(getString(R.string.harrow));
        object.setDescription(getString(R.string.harrow_desc));
        object.setImageResourceId(R.drawable.harrow);

        list.add(object);
        object = new CustomListViewObject();

        object.setSubjectName(getString(R.string.krypton));
        object.setDescription(getString(R.string.krypton_desc));
        object.setImageResourceId(R.drawable.kryptons);
        list.add(object);
        object = new CustomListViewObject();
        object.setSubjectName(getString(R.string.harrow));
        object.setDescription(getString(R.string.harrow_desc));
        object.setImageResourceId(R.drawable.harrow);

        list.add(object);
        object = new CustomListViewObject();

        object.setSubjectName(getString(R.string.krypton));
        object.setDescription(getString(R.string.krypton_desc));
        object.setImageResourceId(R.drawable.kryptons);
        list.add(object);
        return list;
    }
}
