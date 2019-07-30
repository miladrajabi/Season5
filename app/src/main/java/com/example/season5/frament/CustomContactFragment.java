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

import com.example.season5.R;
import com.example.season5.adapter.CustomContactAdapter;
import com.example.season5.objects.CustomContactObject;

import java.util.ArrayList;
import java.util.List;

public class CustomContactFragment extends Fragment {

    RecyclerView rclContact;
    List<CustomContactObject> list;
    CustomContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_custom_contact_fragment, container, false);
        rclContact = v.findViewById(R.id.rcl);

        adapter = new CustomContactAdapter(list);

        list = new ArrayList<>();
        rclContact.setAdapter(adapter);
        rclContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void prepareData() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            list.clear();
            Cursor contacts = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null);

            while (contacts.moveToNext()) {
                String name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                CustomContactObject obj = new CustomContactObject(name, phoneNumber);
                list.add(obj);
            }


        }
        adapter.notifyDataSetChanged();
        if (list.size() == 0) {

        }
    }
}
