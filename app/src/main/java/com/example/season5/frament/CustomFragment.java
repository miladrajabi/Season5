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
import com.example.season5.interfaces.IChatPageMessageListener;
import com.example.season5.objects.ChatPageObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomFragment extends Fragment implements View.OnClickListener {
    AppCompatTextView txtFNoMsg;
    AppCompatEditText chatEditTxt;
    TextView chtTitle;
    AppCompatImageView btnChtBack, imgChtSend;
    RecyclerView rclCht;
    ChatPageAdapter adapter;
    List<ChatPageObject> list = new ArrayList<>();
    boolean me = true;
    boolean seen = false;
    public static IChatPageMessageListener messageListener;


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
        me = !me;
        seen = !seen;
        if (TextUtils.isEmpty(chatEditTxt.getText().toString())) {
            return; // or break, continue, throw
        }
        Calendar c = Calendar.getInstance();

        String time = String.valueOf(c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));

        txtFNoMsg.setVisibility(View.GONE);
        ChatPageObject object = new ChatPageObject();
        object.setMsg(chatEditTxt.getText().toString());
        object.setDate(time);
        object.setSeen(seen);
        object.setMe(me);
        object.setType(ChatPageObject.TYPE_MESSAGE);

        list.add(object);
        rclCht.smoothScrollToPosition(list.size());
        adapter.notifyDataSetChanged();
        chatEditTxt.setText("");
        //txtFNoMsg.setText("");

    }
}
