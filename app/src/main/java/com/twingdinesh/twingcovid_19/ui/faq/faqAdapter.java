package com.twingdinesh.twingcovid_19.ui.faq;

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

public class faqAdapter extends RecyclerView.Adapter<faqAdapter.Viewholder> {

    ArrayList<FAQdata> arrayList;
    Animation anim;

    public faqAdapter(ArrayList<FAQdata> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.faqcardview,parent,false);
        anim= AnimationUtils.loadAnimation(parent.getContext(),R.anim.faqanim);
        view.setAnimation(anim);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
            FAQdata data=arrayList.get(position);
            holder.Question.setText(data.getQuestion());
            holder.answer.setText(data.getAnwer());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView Question,answer;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Question=itemView.findViewById(R.id.faqQuestion);
            answer=itemView.findViewById(R.id.faqAnswer);
        }
    }
}
