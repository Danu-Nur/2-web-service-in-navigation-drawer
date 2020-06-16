package com.example.drawernavigation.ui.webservices2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.drawernavigation.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<PlayerItem> {

    private List<PlayerItem> playerItemsList;

    private Context context;

    public  ListViewAdapter(List<PlayerItem> playerItemsList, Context context){
        super(context, R.layout.list_item2, playerItemsList);
        this.playerItemsList = playerItemsList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item2, null, false);

        TextView textViewNo = listViewItem.findViewById(R.id.textViewNo);
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewPosition = listViewItem.findViewById(R.id.textViewPosition);
        TextView textViewBirthDate = listViewItem.findViewById(R.id.textViewBirthDate);
        ImageView imgView = listViewItem.findViewById(R.id.Poster);

        PlayerItem playerItem = playerItemsList.get(position);

        textViewNo.setText(playerItem.getNo());
        textViewName.setText(playerItem.getName());
        textViewPosition.setText(playerItem.getPosition());
        textViewBirthDate.setText(playerItem.getBirth_date());

        Glide.with(context)
                .load(playerItem.getPoster())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(imgView);

        return listViewItem;
    }
}
