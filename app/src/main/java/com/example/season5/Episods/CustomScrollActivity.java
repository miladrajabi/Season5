package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.season5.R;

public class CustomScrollActivity extends AppCompatActivity implements View.OnClickListener {

    ScrollView parentScrollView;
    Button btnGoToTop;
    TextView txtBookName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scroll);
        setTitle(this.getClass().getSimpleName());
        init();

    }

    private void init() {
        parentScrollView = findViewById(R.id.parentScrollView);
        btnGoToTop = findViewById(R.id.btnGoToTop);
        txtBookName = findViewById(R.id.txtBookName);

        btnGoToTop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGoToTop) {
//            parentScrollView.smoothScrollTo(0,0);
            parentScrollView.fullScroll(ScrollView.FOCUS_UP);
        }
    }
}
