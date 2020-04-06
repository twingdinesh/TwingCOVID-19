package com.twingdinesh.twingcovid_19.ui.faq;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twingdinesh.twingcovid_19.R;

import java.util.ArrayList;

public class FAQ extends Fragment {
    RecyclerView mrecyclerview;
    ArrayList<FAQdata> arrayList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.f_a_q_fragment, container, false);
        mrecyclerview=root.findViewById(R.id.faqrecyclerview);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList=new ArrayList<FAQdata>();
        arrayList.add(new FAQdata("what is corona virus?","Coronaviruses are a large family of viruses which may cause illness in animals or humans.  In humans, several coronaviruses are known to cause respiratory infections ranging from the common cold to more severe diseases such as Middle East Respiratory Syndrome (MERS) and Severe Acute Respiratory Syndrome (SARS). The most recently discovered coronavirus causes coronavirus disease COVID-19."));
        arrayList.add(new FAQdata("what is COVID19?","COVID-19 is the infectious disease caused by the most recently discovered coronavirus. This new virus and disease were unknown before the outbreak began in Wuhan, China, in December 2019."));
        arrayList.add(new FAQdata("what are the symptoms of COVID19?","The most common symptoms of COVID-19 are fever, tiredness, and dry cough. Some patients may have aches and pains, nasal congestion, runny nose, sore throat or diarrhea. These symptoms are usually mild and begin gradually. Some people become infected but don’t develop any symptoms and don't feel unwell. Most people (about 80%) recover from the disease without needing special treatment. Around 1 out of every 6 people who gets COVID-19 becomes seriously ill and develops difficulty breathing. Older people, and those with underlying medical problems like high blood pressure, heart problems or diabetes, are more likely to develop serious illness. People with fever, cough and difficulty breathing should seek medical attention."));
        arrayList.add(new FAQdata("Can the virus that causes COVID-19 be transmitted through the air?","Studies to date suggest that the virus that causes COVID-19 is mainly transmitted through contact with respiratory droplets rather than through the air.  See previous answer on “How does COVID-19 spread?”"));
        arrayList.add(new FAQdata("Can CoVID-19 be caught from a person who has no symptoms?","The main way the disease spreads is through respiratory droplets expelled by someone who is coughing. The risk of catching COVID-19 from someone with no symptoms at all is very low. However, many people with COVID-19 experience only mild symptoms. This is particularly true at the early stages of the disease. It is therefore possible to catch COVID-19 from someone who has, for example, just a mild cough and does not feel ill.  WHO is assessing ongoing research on the period of transmission of COVID-19 and will continue to share updated findings."));
        arrayList.add(new FAQdata("should i wear a mask to protuct myself?","Only wear a mask if you are ill with COVID-19 symptoms (especially coughing) or looking after someone who may have COVID-19. Disposable face mask can only be used once. If you are not ill or looking after someone who is ill then you are wasting a mask. There is a world-wide shortage of masks, so WHO urges people to use masks wisely.\n" +
                "\n" +
                "WHO advises rational use of medical masks to avoid unnecessary wastage of precious resources and mis-use of masks  (see Advice on the use of masks).\n" +
                "\n" +
                "The most effective ways to protect yourself and others against COVID-19 are to frequently clean your hands, cover your cough with the bend of elbow or tissue and maintain a distance of at least 1 meter (3 feet) from people who are coughing or sneezing. See basic protective measures against the new coronavirus for more information."));
        arrayList.add(new FAQdata("How long does the virus survive on surfaces?\n","It is not certain how long the virus that causes COVID-19 survives on surfaces, but it seems to behave like other coronaviruses. Studies suggest that coronaviruses (including preliminary information on the COVID-19 virus) may persist on surfaces for a few hours or up to several days. This may vary under different conditions (e.g. type of surface, temperature or humidity of the environment).\n" +
                "\n" +
                "If you think a surface may be infected, clean it with simple disinfectant to kill the virus and protect yourself and others. Clean your hands with an alcohol-based hand rub or wash them with soap and water. Avoid touching your eyes, mouth, or nose."));
        arrayList.add(new FAQdata("Is there anything I should not do?","The following measures ARE NOT effective against COVID-2019 and can be harmful:\n" +
                "\n" +
                "Smoking\n" +
                "Wearing multiple masks\n" +
                "Taking antibiotics (See question 10 \"Are there any medicines of therapies that can prevent or cure COVID-19?\")\n" +
                "In any case, if you have fever, cough and difficulty breathing seek medical care early to reduce the risk of developing a more severe infection and be sure to share your recent travel history with your health care provider."));
        faqAdapter adapter=new faqAdapter(arrayList);
        mrecyclerview.setAdapter(adapter);
        return root;
    }


}
