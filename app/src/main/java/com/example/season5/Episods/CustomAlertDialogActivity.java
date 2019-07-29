package com.example.season5.Episods;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

import com.example.season5.R;

public class CustomAlertDialogActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatEditText cadEtTitle, cadEtMsg, cadEtPositive, cadEtNegative, cadEtNeutral;
    AppCompatEditText cadChkPositive, cadChkcadEtPositive, cadChkcadEtNeutral, cadChkcadEtDismiss;
    FloatingActionButton cadFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alert_dialog);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {
        cadEtTitle = findViewById(R.id.cadEtTitle);
        cadEtPositive = findViewById(R.id.cadEtPositive);
        cadEtNegative = findViewById(R.id.cadEtNegative);
        cadEtNeutral = findViewById(R.id.cadEtNeutral);
        cadEtMsg = findViewById(R.id.cadEtMsg);

        cadChkPositive = findViewById(R.id.cadChkPositive);
        cadChkcadEtPositive = findViewById(R.id.cadChkcadEtPositive);
        cadChkcadEtNeutral = findViewById(R.id.cadChkcadEtNeutral);
        cadChkcadEtDismiss = findViewById(R.id.cadChkcadEtDismiss);

        cadFab = findViewById(R.id.cadFab);
        cadFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cadFab) {
            prepareDialog();
        }
    }

    private void prepareDialog() {
        String titleStr = TextUtils.isEmpty(cadEtTitle.getText().toString()) ? getString(R.string.nav_header_title) : cadEtTitle.getText().toString();
        String msgStr = TextUtils.isEmpty(cadEtTitle.getText().toString()) ? getString(R.string.type_your_message) : cadEtMsg.getText().toString();
        String positiveStr = TextUtils.isEmpty(cadEtPositive.getText().toString()) ? getString(R.string.harrow) : cadEtPositive.getText().toString();
        String negativeStr = TextUtils.isEmpty(cadEtNegative.getText().toString()) ? getString(R.string.krypton) : cadEtNegative.getText().toString();
        String neutralStr = TextUtils.isEmpty(cadEtNeutral.getText().toString()) ? getString(R.string.krypton) : cadEtNeutral.getText().toString();

    }
}
