package com.twingdinesh.twingcovid_19.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.twingdinesh.twingcovid_19.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment {

    TextView Globalrecover,Globalaffected,Globaldeath,updatetime;
    ProgressBar progressBar;
    Animation translate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
            Globalaffected=root.findViewById(R.id.globalTotalAffected);
            Globalrecover=root.findViewById(R.id.GlobalTotalrecover);
            Globaldeath=root.findViewById(R.id.GlobalTotalDeath);
            progressBar=root.findViewById(R.id.GlobalProgress);
            updatetime=root.findViewById(R.id.updatetime);
            translate= AnimationUtils.loadAnimation(getActivity(),R.anim.zoom);
            getdata();
            root.setAnimation(translate);
        return root;
    }
    public String date(long milliseconds)
    {
        SimpleDateFormat format=new SimpleDateFormat("EEE, dd mm yyyy hh:mm:ss aaa");
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return  format.format(calendar.getTime());
    }
    private void getdata() {

        RequestQueue queue= Volley.newRequestQueue(getActivity());
        String url="https://corona.lmao.ninja/all";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject=new JSONObject(response.toString());
                    Globalaffected.setText(jsonObject.getString("cases"));
                    Globaldeath.setText(jsonObject.getString("deaths"));
                    Globalrecover.setText(jsonObject.getString("recovered"));
                    updatetime.setText("last updated"+"\n"+date(jsonObject.getLong("updated")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        queue.add(stringRequest);
    }
}
