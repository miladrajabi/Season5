package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.season5.R;

public class CustomPermissionActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCheck;
    TextView txtPermission;

    public static final int REQUEST_CODE = 115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_permission);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        btnCheck = findViewById(R.id.btnCheck);
        txtPermission = findViewById(R.id.txtPermission);

        btnCheck.setOnClickListener(this);
    }

    private void getPermission() {

        

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnCheck) {
            getPermission();
        }
    }
}
