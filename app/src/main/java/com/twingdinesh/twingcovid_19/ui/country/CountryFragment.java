package com.twingdinesh.twingcovid_19.ui.country;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
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
import com.twingdinesh.twingcovid_19.countrydetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountryFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    Animation countryanim;
    ArrayList<Covidcountry> covidcountries;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView=root.findViewById(R.id.recyclerview);
        progressBar=root.findViewById(R.id.CountryProgress);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getdata();
        countryanim=AnimationUtils.loadAnimation(getActivity(),R.anim.righttoleft);
        root.setAnimation(countryanim);
        return root;
    }
    public void showcountrydetails(String mccountryname,String cases,String todaycase,String death,String todaydeath,String active,String recoverd,String crititcal)
    {
        Intent intent=new Intent(getActivity(), countrydetails.class);
        Bundle bundle=new Bundle();
        bundle.putString("countryname",mccountryname);
        bundle.putString("cases",cases);
        bundle.putString("todaycase",todaycase);
        bundle.putString("death",death);
        bundle.putString("todaydeath",todaydeath);
        bundle.putString("active",active);
        bundle.putString("recoverd",recoverd);
        bundle.putString("critical",crititcal);
        intent.putExtras(bundle);
        startActivity(intent);
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
                        JSONObject object=jsonObject.getJSONObject("countryInfo");
                        covidcountries.add(new Covidcountry(jsonObject.getString( "country"),jsonObject.getString("cases"),jsonObject.getString("deaths"),
                                jsonObject.getString("todayDeaths"),jsonObject.getString("todayCases"),jsonObject.getString("recovered"),jsonObject.getString("critical"),jsonObject.getString("active"),object.getString("flag")));

                    }
                    CovidCountryAdaptor countryAdaptor=new CovidCountryAdaptor(covidcountries,getActivity());


                    recyclerView.setAdapter(countryAdaptor);
                    ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                            Covidcountry covid=covidcountries.get(position);
                            showcountrydetails(covid.getMcountryname(),covid.getMcases(),covid.getMtodaycases(),covid.getMdeath()
                            ,covid.getMtodaysdeath(), covid.getMactive(),covid.getMrecover(),covid.getMcritical());

                        }
                    });
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

