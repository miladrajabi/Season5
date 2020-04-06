package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.season5.R;

public class CostomFontActivity extends AppCompatActivity {

    TextView txtFirst, txtSecond, txtThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costom_font);
        setTitle(this.getClass().getSimpleName());
        init();
        setFont();
    }

    private void setFont() {
    }

    private void init() {
        txtFirst = findViewById(R.id.txtFirst);
        txtSecond = findViewById(R.id.txtSecond);
        txtThird = findViewById(R.id.txtThird);

        txtThird.append(" " + getString(R.string.loremIpsumText));
    }
}
