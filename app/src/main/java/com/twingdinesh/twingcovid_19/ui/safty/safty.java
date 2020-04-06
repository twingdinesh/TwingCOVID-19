package com.twingdinesh.twingcovid_19.ui.safty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twingdinesh.twingcovid_19.R;

import java.util.ArrayList;


public class safty extends Fragment {

    ArrayList<String> dolist,dontlist;
    RecyclerView dorv,dontrv;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_safty, container, false);
        dorv=root.findViewById(R.id.dorv);
        dontrv=root.findViewById(R.id.dontrv);

        dorv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        dorv.setHorizontalFadingEdgeEnabled(true);

        dontrv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true));
        dontrv.setHorizontalFadingEdgeEnabled(true);


        dolist=new ArrayList<String>();
        dontlist=new ArrayList<String>();


        dolist.add("Practice frequent hand\n" +
                "washing. Wash hands with\n" +
                "soap and water or use alcohol\n" +
                "based hand rub. Wash hands\n" +
                "even if they are visibly clean");
        dolist.add("Cover your nose and\n" +
                "mouth with\n" +
                "handkerchief/tissue while\n" +
                "sneezing and coughing");
        dolist.add("Throw used\n" +
                "tissues into closed\n" +
                "bins immediately\n" +
                "after use");
        dolist.add("See a doctor if you feel unwell\n" +
                "(fever, difficult breathing and\n" +
                "cough). While visiting doctor\n" +
                "wear a mask/cloth to cover\n" +
                "your mouth and nose");
        dolist.add("If you have these\n" +
                "signs/symptoms please\n" +
                "call State helpline number\n" +
                "or Ministry of Health &\n" +
                "Family Welfare’s 24X7\n" +
                "helpline at 011-23978046");
        dolist.add("Avoid participating\n" +
                "in large gatherings");
        dolist.add("Clean and disinfect frequently-touched objects and surfaces using a regular household cleaning spray or wipe");
        dolist.add("Wearing a mask is not necessary unless you are taking care of an infected person. The Centers for Disease Control (CDC) does recommend that only infected people wear masks to prevent the spread of the virus");
        dolist.add("If soap and water are not readily available, use an alcohol-based hand sanitiser with at least 60% alcohol. Always wash hands with soap and water when hands are visibly dirty");
        dolist.add("Cover your cough or sneeze with a tissue, then dispose of the tissue safely");

                 dolist.add("Avoid touching your eyes, nose, and mouth");



        dontlist.add("Have a close contact\n" +
                "with anyone, if you’re\n" +
                "experiencing cough\n" +
                "and fever");
        dontlist.add("Touch your eyes,\n" +
                "nose and mouth");
        dontlist.add("Spit in public");
        dontlist.add("Don’t go to crowded areas");
        dontlist.add("Don’t leave your home, especially if sick");
        dontlist.add("Do not believe everything on the internet");
        dontlist.add("Do not seek alternative treatments");
        dontlist.add("Do not take antibiotics");
        dontlist.add("Do not propagate hostility against Asians ");
        dontlist.add("Do not panic");


        dontadapter dontadapter=new dontadapter(dontlist);
        saftyadapter doadapter=new saftyadapter(dolist);
        dorv.setAdapter(doadapter);
        dontrv.setAdapter(dontadapter);
        return root;
    }
}
