package com.twingdinesh.twingcovid_19.ui.india;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.twingdinesh.twingcovid_19.R;

import java.util.ArrayList;

public class indiaadapter extends RecyclerView.Adapter<indiaadapter.viewholder> {

    ArrayList<indiahelperclass> arrayList;
    private Animation anim;
    public indiaadapter(ArrayList<indiahelperclass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.indiastatecardview,parent,false);
        anim= AnimationUtils.loadAnimation(parent.getContext(),R.anim.indiaanim);
        view.setAnimation(anim);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            indiahelperclass indiahelperclass=arrayList.get(position);
            holder.statedeath.setText(indiahelperclass.getStatedeath());
            holder.statename.setText(indiahelperclass.getStatename());
            holder.staterecover.setText(indiahelperclass.getStaterecover());
            holder.statecase.setText(indiahelperclass.getStatecases());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView statename,statecase,staterecover,statedeath;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            statecase=itemView.findViewById(R.id.activestate);
            statename=itemView.findViewById(R.id.statename);
            staterecover=itemView.findViewById(R.id.recoverstate);
            statedeath=itemView.findViewById(R.id.deadstate);
        }
    }
}
