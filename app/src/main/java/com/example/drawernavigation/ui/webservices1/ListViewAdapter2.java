package com.example.drawernavigation.ui.webservices1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.drawernavigation.R;

import java.util.List;

public class ListViewAdapter2 extends ArrayAdapter<UserItem> {
    private List<UserItem> userItemList;

    private Context context;

    public  ListViewAdapter2(List<UserItem> userItemList, Context context){
        super(context, R.layout.list_item1, userItemList);
        this.userItemList = userItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item1, null, false);

        TextView textViewNo = listViewItem.findViewById(R.id.textViewNo1);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName1);

        UserItem playerItem = userItemList.get(position);

        textViewNo.setText(playerItem.getNo());
        textViewName.setText(playerItem.getName());

        return listViewItem;
    }
}
