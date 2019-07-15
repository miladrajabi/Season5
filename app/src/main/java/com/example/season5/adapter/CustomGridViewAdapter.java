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
import com.example.season5.objects.CustomListViewObject;

import java.util.List;

public class CustomGridViewAdapter extends ArrayAdapter<CustomListViewObject> {
    List<CustomListViewObject> objects;


    public CustomGridViewAdapter(@NonNull Context context, int resource, @NonNull List<CustomListViewObject> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_custom_gridview_row, parent, false);
        ImageView imgListView = view.findViewById(R.id.imgListView);
        TextView txtSubject = view.findViewById(R.id.txtSubject);
        TextView txtDesc = view.findViewById(R.id.txtDesc);

        txtSubject.setText(objects.get(position).getSubjectName());
        txtDesc.setText(objects.get(position).getDescription());
        imgListView.setImageResource(objects.get(position).getImageResourceId());
        return view;
    }
}
