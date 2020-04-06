package com.twingdinesh.twingcovid_19.ui.safty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.twingdinesh.twingcovid_19.R;

import java.util.ArrayList;

public class dontadapter extends RecyclerView.Adapter<dontadapter.viewholder> {
    ArrayList<String> list;

    public dontadapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dontcardview,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        String name=list.get(position);
        holder.text.setText(name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView text;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.donttext);
        }
    }
}
