package com.example.drawernavigation.ui.menu3;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.drawernavigation.R;

import java.util.ArrayList;

public class Menu3Fragment extends Fragment {

    public static Menu3Fragment newInstance() {
        return new Menu3Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.menu3_fragment, container, false);

        ArrayList<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_list_item_1,
                data
        );
        ListView listView = root.findViewById(R.id.menu3);
        listView.setAdapter(adapter);
        return root;
    }

}
