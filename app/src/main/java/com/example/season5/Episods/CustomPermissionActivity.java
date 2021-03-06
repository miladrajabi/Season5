package com.example.season5.Episods;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.app.app;

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

    private Boolean checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
            app.toast("Version" + result);

            if (result == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE);
        } else {
            return true;
        }
        return false;
    }

    private void myAction() {
        txtPermission.setText(R.string.permissionGenerat);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnCheck) {
            if (checkPermission()) {
                myAction();
            }


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case REQUEST_CODE: {
                app.toast("Code : " + grantResults[0]);
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    myAction();
                } else {
                    txtPermission.setText(getString(R.string.permissionDenied));
                }
                break;
            }
            default: {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            }
        }

    }
}
