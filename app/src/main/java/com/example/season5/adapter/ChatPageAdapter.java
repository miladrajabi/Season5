package com.example.season5.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.app.Application;
import com.example.season5.objects.ChatPageObject;

import java.util.List;

public class ChatPageAdapter extends RecyclerView.Adapter<ChatPageAdapter.chatPageViewHolder> {
    List<ChatPageObject> objects;

    public ChatPageAdapter() {
    }

    public ChatPageAdapter(List<ChatPageObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public chatPageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_chat_row_me, viewGroup, false);

        return new chatPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatPageViewHolder chatPageViewHolder, int i) {
        chatPageViewHolder.txtMsgMe.setText(objects.get(i).getMsg());
        chatPageViewHolder.txtTime.setText(objects.get(i).getDate());
        if (!objects.get(i).getSeen()) {
            chatPageViewHolder.imgSeen.setImageResource(R.drawable.ic_done_black_24dp);
        } else {
            chatPageViewHolder.imgSeen.setImageResource(R.drawable.ic_done_all_black_24dp);

        }
        if (objects.get(i).getMe()) {
            chatPageViewHolder.txtMsgMe.setTextColor(Color.RED);
        } else {
            chatPageViewHolder.txtMsgMe.setTextColor(Color.DKGRAY);
        }


    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class chatPageViewHolder extends RecyclerView.ViewHolder {

        TextView txtMsgMe, txtTime;
        AppCompatImageView imgSeen;

        public chatPageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMsgMe = itemView.findViewById(R.id.txtMsgMe);
            txtTime = itemView.findViewById(R.id.txtTime);
            imgSeen = itemView.findViewById(R.id.imgSeen);

        }
    }
}
