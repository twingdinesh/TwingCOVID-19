package com.twingdinesh.twingcovid_19.ui.india;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.twingdinesh.twingcovid_19.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class india extends Fragment {

    private RecyclerView staterv;
    private ProgressBar progressBar;
    private ArrayList<indiahelperclass> arrayList;
    private LinearLayout linearLayout;
    Animation animation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_india, container, false);
        staterv=root.findViewById(R.id.rvindia);
        linearLayout=root.findViewById(R.id.linearlayout);
        progressBar=root.findViewById(R.id.progressbar_india);
        staterv.setLayoutManager(new LinearLayoutManager(getActivity()));
        animation= AnimationUtils.loadAnimation(getActivity(),R.anim.indiaanim);
        linearLayout.setAnimation(animation);
        getdata();
        return root;
    }
    private void getdata() {
        String url="https://api.covid19india.org/data.json";
        arrayList=new ArrayList<>();
        JsonObjectRequest stringRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray = response.getJSONArray("statewise");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        arrayList.add(new indiahelperclass(jsonObject.getString( "state"),jsonObject.getString("deaths"),jsonObject.getString("recovered"),
                                jsonObject.getString("confirmed")));

                    }
                    indiaadapter adapter=new indiaadapter(arrayList);
                    staterv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }
}
