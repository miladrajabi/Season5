package com.example.season5.adapter;

import android.support.annotation.NonNull;
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
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class chatPageViewHolder extends RecyclerView.ViewHolder {

        TextView txtMsgMe;

        public chatPageViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMsgMe = itemView.findViewById(R.id.txtMsgMe);

        }
    }
}
