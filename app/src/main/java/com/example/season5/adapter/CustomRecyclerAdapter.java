package com.example.season5.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.app.Application;
import com.example.season5.interfaces.CustomRecyclerViewClickListener;
import com.example.season5.objects.CustomRecyclerObject;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {

    List<CustomRecyclerObject> objects;
    CustomRecyclerViewClickListener clickListener;

    public CustomRecyclerAdapter(List<CustomRecyclerObject> list, CustomRecyclerViewClickListener itemClickListener) {
        this.objects = list;
        this.clickListener = itemClickListener;
    }

    public CustomRecyclerAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.custom_recyclerview_row, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.crSongName.setText(objects.get(i).getSongName());
        myViewHolder.crSingerName.setText(objects.get(i).getSingerName());
        myViewHolder.crTxtLike.setText(objects.get(i).getLike() + "");
        myViewHolder.crTxtComment.setText(objects.get(i).getComment() + "");
        myViewHolder.crTxtDate.setText(objects.get(i).getDate() + "");
        myViewHolder.crTxtView.setText(objects.get(i).getView() + "");
        myViewHolder.imgSong.setImageResource(objects.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView crTxtView, crTxtLike, crTxtComment, crTxtDate, crSongName, crSingerName;
        ImageView imgSong;
        LinearLayout rlRclParent;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            crTxtLike = itemView.findViewById(R.id.crTxtLike);
            crTxtComment = itemView.findViewById(R.id.crTxtComment);
            crTxtDate = itemView.findViewById(R.id.crTxtDate);
            crTxtView = itemView.findViewById(R.id.crTxtView);

            crSongName = itemView.findViewById(R.id.crSongName);
            crSingerName = itemView.findViewById(R.id.crSingerName);
            imgSong = itemView.findViewById(R.id.imgSong);

            rlRclParent = itemView.findViewById(R.id.rlRclParent);

            rlRclParent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.OnClick(objects.get(getAdapterPosition()));
        }
    }
}
