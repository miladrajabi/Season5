package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.season5.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setTitle(this.getClass().getSimpleName());
        
        init();
    }

    private void init() {
    }
}
