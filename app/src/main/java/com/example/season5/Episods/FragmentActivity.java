package com.example.season5.Episods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.season5.R;
import com.example.season5.app.app;
import com.example.season5.frament.CustomFragment;
import com.example.season5.interfaces.IChatPageMessageListener;
import com.example.season5.objects.ChatPageObject;

public class FragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        setTitle(this.getClass().getSimpleName());

        init();
    }

    private void init() {
        CustomFragment.messageListener = new IChatPageMessageListener() {
            @Override
            public void onMessage(ChatPageObject object) {
                app.toast(object.getMsg());
            }
        };
    }
}
