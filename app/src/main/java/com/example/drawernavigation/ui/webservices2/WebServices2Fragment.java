package com.example.drawernavigation.ui.webservices2;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawernavigation.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebServices2Fragment extends Fragment {

    public static WebServices2Fragment newInstance() {
        return new WebServices2Fragment();
    }

    private static final String JSON_URL = "https://azharsaepudin.github.io/FootBallPlayer/AllPlayer.json";
    ListView listView;
    private List<PlayerItem> playerItemList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.web_services2_fragment, container, false);

        playerItemList = new ArrayList<>();


        listView = root.findViewById(R.id.listView2);

        loadPlayer();

        return root;
    }

    private void loadPlayer(){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("result");

                            for (int i = 0; i < playerArray.length(); i++) {
                                JSONObject playerObject = playerArray.getJSONObject(i);
//
                                PlayerItem playerItem = new PlayerItem(
                                        playerObject.getString("no"),
                                        playerObject.getString("name"),
                                        playerObject.getString("Position"),
                                        playerObject.getString("birth_date"),
                                        playerObject.getString("Poster")
                                );

                                playerItemList.add(playerItem);
                            }
                            ListViewAdapter adapter = new ListViewAdapter(playerItemList, getContext());
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(stringRequest);
    }

}
