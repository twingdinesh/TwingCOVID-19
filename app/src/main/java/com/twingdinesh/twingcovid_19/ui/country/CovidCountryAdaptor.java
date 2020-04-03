package com.twingdinesh.twingcovid_19.ui.country;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.twingdinesh.twingcovid_19.R;

import java.util.ArrayList;

public class CovidCountryAdaptor extends RecyclerView.Adapter<CovidCountryAdaptor.viewholder> {

    ArrayList<Covidcountry> covidcountries;
    Context mcontext;


    public CovidCountryAdaptor(ArrayList<Covidcountry> covidcountries,Context mcontext) {
        this.covidcountries = covidcountries;
        this.mcontext=mcontext;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_country,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            Covidcountry covidcountry=covidcountries.get(position);
            holder.cases.setText(covidcountry.getMcases());
            holder.countryname.setText(covidcountry.getMcountryname());
        Glide.with(mcontext).load(covidcountry.getMflags()).apply(new RequestOptions().override(240,160)).into(holder.flag);
    }

    @Override
    public int getItemCount() {
        return covidcountries.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView countryname,cases;
        ImageView flag;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            countryname=itemView.findViewById(R.id.countryname);
            cases=itemView.findViewById(R.id.countrytotal);
            flag=itemView.findViewById(R.id.flag);
        }
    }
}
