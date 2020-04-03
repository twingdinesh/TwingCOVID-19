package com.twingdinesh.twingcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.twingdinesh.twingcovid_19.ui.country.Covidcountry;

import org.w3c.dom.Text;

public class countrydetails extends AppCompatActivity {
    TextView dcountryname,dtotalcase,dtotalrecoverd,dtodaycase,dtotaldeath,dtodaydeath,dtotalcritical,dtotalactive,totalrecoverdlable,lab2,lab3,lab4,lab5,lab6;
    Animation left,right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrydetails);
        dcountryname=(TextView)findViewById(R.id.detailcountryname);
        dtotalcase=(TextView)findViewById(R.id.detailtotal);
        dtotalrecoverd=(TextView)findViewById(R.id.detailtotalrecoverd);
        dtodaycase=(TextView)findViewById(R.id.detailtodaycases);
        dtotaldeath=(TextView)findViewById(R.id.dtotaldeath);
        dtodaydeath=(TextView)findViewById(R.id.dtodaydeath);
        dtotalcritical=(TextView)findViewById(R.id.dtotalcritical);
        dtotalactive=(TextView)findViewById(R.id.dtotalactive);
        totalrecoverdlable=(TextView)findViewById(R.id.totalrecoverdlable);
        lab2=(TextView)findViewById(R.id.lable2);
        lab3=(TextView)findViewById(R.id.lable3);
        lab4=(TextView)findViewById(R.id.lable4);
        lab5=(TextView)findViewById(R.id.lable5);
        lab6=(TextView)findViewById(R.id.lable6);

        left= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        right=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.righttoleft);

        Bundle bundle=getIntent().getExtras();

        dcountryname.setText(bundle.getString("countryname"));
        dtotalcase.setText(bundle.getString("cases"));
        dtotalrecoverd.setText(bundle.getString("recoverd"));
        dtodaycase.setText(bundle.getString("todaycase"));
        dtotaldeath.setText(bundle.getString("death"));
        dtodaydeath.setText(bundle.getString("todaydeath"));
        dtotalcritical.setText(bundle.getString("critical"));
        dtotalactive.setText(bundle.getString("active"));

        dtotalrecoverd.setAnimation(left);
        dtodaycase.setAnimation(left);
        dtodaydeath.setAnimation(left);
        dtotalcritical.setAnimation(left);
        dtotalactive.setAnimation(left);
        dtotaldeath.setAnimation(left);

        totalrecoverdlable.setAnimation(right);
        lab2.setAnimation(right);
        lab3.setAnimation(right);
        lab4.setAnimation(right);
        lab5.setAnimation(right);
        lab6.setAnimation(right);


    }
}
