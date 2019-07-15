package com.example.season5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.app.Application;
import com.example.season5.objects.spinnerCustomObject;

import java.util.List;

public class spinnerAdapter extends ArrayAdapter<spinnerCustomObject> {
    List<spinnerCustomObject> list;

    public spinnerAdapter(@NonNull Context context, int resource, @NonNull List<spinnerCustomObject> objects) {
        super(context, resource, objects);
        this.list = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_spnr_row, parent, false);
        ImageView imgOs = view.findViewById(R.id.imgOs);
        TextView txtOs = view.findViewById(R.id.txtOs);

        txtOs.setText(list.get(position).getName());
        imgOs.setImageResource(list.get(position).getDrawable());
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_spnr_row, parent, false);
        ImageView imgOs = view.findViewById(R.id.imgOs);
        TextView txtOs = view.findViewById(R.id.txtOs);

        txtOs.setText(list.get(position).getName());
        imgOs.setImageResource(list.get(position).getDrawable());
        return view;
    }
}
