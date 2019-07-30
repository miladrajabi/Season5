package com.example.season5.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.app.Application;
import com.example.season5.objects.CustomContactObject;

import java.util.List;

public class CustomContactAdapter extends RecyclerView.Adapter<CustomContactAdapter.MyViewHolder> {

    List<CustomContactObject> objects;

    public CustomContactAdapter(List<CustomContactObject> objects) {
        this.objects = objects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.custom_contacts_row, viewGroup, false);

        return new CustomContactAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtContactName.setText(objects.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtContactName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtContactName = itemView.findViewById(R.id.txtContactName);
        }
    }

}
