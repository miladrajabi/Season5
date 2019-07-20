package com.example.season5.frament;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.adapter.ChatPageAdapter;
import com.example.season5.objects.ChatPageObject;

import java.util.ArrayList;
import java.util.List;

public class CustomFragment extends Fragment implements View.OnClickListener {
    AppCompatTextView txtFNoMsg;
    AppCompatEditText chatEditTxt;
    TextView chtTitle;
    AppCompatImageView btnChtBack, imgChtSend;
    RecyclerView rclCht;
    ChatPageAdapter adapter;
    List<ChatPageObject> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_custom_fragment_row, container, false);

        txtFNoMsg = view.findViewById(R.id.txtFNoMsg);
        chatEditTxt = view.findViewById(R.id.chatEditTxt);
        chtTitle = view.findViewById(R.id.chtTitle);
        btnChtBack = view.findViewById(R.id.btnChtBack);
        imgChtSend = view.findViewById(R.id.imgChtSend);

        btnChtBack.setOnClickListener(this);
        imgChtSend.setOnClickListener(this);


        adapter = new ChatPageAdapter(list);

        rclCht = view.findViewById(R.id.rclCht);
        rclCht.setAdapter(adapter);
        rclCht.setLayoutManager(new LinearLayoutManager(getActivity()));
        rclCht.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left)));

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChtBack: {
                getActivity().finish();
                return;
            }
            case R.id.imgChtSend: {
                sendMessage();
                break;
            }


        }
    }

    private void sendMessage() {
        if (TextUtils.isEmpty(chatEditTxt.getText().toString())) {
            return; // or break, continue, throw
        }
        txtFNoMsg.setVisibility(View.GONE);
        ChatPageObject object = new ChatPageObject();
        object.setMsg(chatEditTxt.getText().toString());
        list.add(object);
        adapter.notifyDataSetChanged();
        chatEditTxt.setText("");
        //txtFNoMsg.setText("");

    }
}
