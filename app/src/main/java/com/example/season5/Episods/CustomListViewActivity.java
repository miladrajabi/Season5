package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.season5.R;
import com.example.season5.adapter.CustomListViewAdapter;
import com.example.season5.app.app;
import com.example.season5.objects.CustomListViewObject;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lstViewShow;

    List<CustomListViewObject> list;
    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {

        lstViewShow = findViewById(R.id.lstViewShow);
        list = new ArrayList<>();
        list = prepareData();
        adapter = new CustomListViewAdapter(this, 0, list);
        lstViewShow.setAdapter(adapter);

        lstViewShow.setOnItemClickListener(this);
        lstViewShow.setOnItemLongClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        app.toast(list.get(position).getSubjectName());
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        app.toast(list.get(position).getSubjectName() + " Removed ");
        list.remove(position);
        adapter.notifyDataSetChanged();

        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                app.toast("Milad");
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return true;
    }
}
