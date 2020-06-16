package com.example.drawernavigation.ui.webservices1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drawernavigation.R;
import com.example.drawernavigation.ui.webservices2.ListViewAdapter;
import com.example.drawernavigation.ui.webservices2.PlayerItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WebServices1Fragment extends Fragment {

    private static final String JSON_URL = "http://goexbi.website/showjason.php";

    private ListView listView;

    private List<UserItem> userItemList;


    public static WebServices1Fragment setInstance() { return new WebServices1Fragment(); }

  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
      View root = inflater.inflate(R.layout.web_services1_fragment, container, false);

      userItemList = new ArrayList<>();

      listView = root.findViewById(R.id.listView1);
      loadUser();
      return root;
    }

    private void loadUser(){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("data");

                            for (int i = 0; i < playerArray.length(); i++) {
                                JSONObject playerObject = playerArray.getJSONObject(i);
//
                                UserItem userItem = new UserItem(
                                        playerObject.getString("no_pendaftaran"),
                                        playerObject.getString("username")
                                );

                                userItemList.add(userItem);
                            }
                            ListViewAdapter2 adapter = new ListViewAdapter2(userItemList, getContext());
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
