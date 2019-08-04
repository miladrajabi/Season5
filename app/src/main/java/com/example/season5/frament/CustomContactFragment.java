package com.example.season5.frament;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.season5.R;
import com.example.season5.adapter.CustomContactAdapter;
import com.example.season5.interfaces.ICustomContactListener;
import com.example.season5.objects.CustomContactObject;

import java.util.ArrayList;
import java.util.List;

public class CustomContactFragment extends Fragment {

    RecyclerView rclCnt;
    List<CustomContactObject> list;
    CustomContactAdapter adapter;
    TextView txtNocnt;
    public static ICustomContactListener customContactListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_custom_contact_fragment, container, false);
        rclCnt = v.findViewById(R.id.rclCnt);
        txtNocnt = v.findViewById(R.id.txtNocnt);

        adapter = new CustomContactAdapter(list);

        list = new ArrayList<>();
        rclCnt.setAdapter(adapter);
        rclCnt.setLayoutManager(new LinearLayoutManager(getActivity()));

        customContactListener = new ICustomContactListener() {
            @Override
            public void onPermissionChange(boolean granted) {
                if (granted) {
                    prepareData();
                } else {

                }
            }
        };
        return v;
    }

    public void prepareData() {

        txtNocnt.setVisibility(View.GONE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            list.clear();
            Cursor contacts = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null);

            contacts.moveToFirst();
            while (contacts.moveToNext()) {
                String name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                CustomContactObject obj = new CustomContactObject(name, phoneNumber);
                list.add(obj);
            }
            contacts.close();
        }
        adapter.notifyDataSetChanged();
        if (list.size() == 0) {
            txtNocnt.setVisibility(View.VISIBLE);
        }
    }
}
