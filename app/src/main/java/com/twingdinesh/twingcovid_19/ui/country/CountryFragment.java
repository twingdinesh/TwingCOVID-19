package com.twingdinesh.twingcovid_19.ui.country;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.twingdinesh.twingcovid_19.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<Covidcountry> covidcountries;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView=root.findViewById(R.id.recyclerview);
        progressBar=root.findViewById(R.id.CountryProgress);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getdata();
        return root;
    }

    private void getdata() {
            String url="https://corona.lmao.ninja/countries";
           covidcountries=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        covidcountries.add(new Covidcountry(jsonObject.getString("country"),jsonObject.getString("cases")));

                    }
                    CovidCountryAdaptor countryAdaptor=new CovidCountryAdaptor(covidcountries);
                    recyclerView.setAdapter(countryAdaptor);
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
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }
}
