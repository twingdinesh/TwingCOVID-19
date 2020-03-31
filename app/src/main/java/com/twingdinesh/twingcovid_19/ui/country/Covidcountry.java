package com.twingdinesh.twingcovid_19.ui.country;

public class Covidcountry {
    String mcountryname,mcases,mdeath,mtodaysdeath,mtodaycases,mrecover,mcritical;

    public Covidcountry(String mcountryname, String mcases) {
        this.mcountryname = mcountryname;
        this.mcases = mcases;
        this.mdeath = mdeath;
        this.mtodaysdeath = mtodaysdeath;
        this.mtodaycases = mtodaycases;
        this.mrecover = mrecover;
        this.mcritical = mcritical;
    }

    public String getMcountryname() {
        return mcountryname;
    }

    public String getMcases() {
        return mcases;
    }
}
