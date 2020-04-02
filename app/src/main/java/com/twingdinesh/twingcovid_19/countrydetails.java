package com.twingdinesh.twingcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.twingdinesh.twingcovid_19.ui.country.Covidcountry;

import org.w3c.dom.Text;

public class countrydetails extends AppCompatActivity {
    TextView dcountryname,dtotalcase,dtotalrecoverd,dtodaycase,dtotaldeath,dtodaydeath,dtotalcritical,dtotalactive;

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

        Bundle bundle=getIntent().getExtras();

        dcountryname.setText(bundle.getString("countryname"));
        dtotalcase.setText(bundle.getString("cases"));
        dtotalrecoverd.setText(bundle.getString("recoverd"));
        dtodaycase.setText(bundle.getString("todaycase"));
        dtotaldeath.setText(bundle.getString("death"));
        dtodaydeath.setText(bundle.getString("todaydeath"));
        dtotalcritical.setText(bundle.getString("critical"));
        dtotalactive.setText(bundle.getString("active"));
    }
}
