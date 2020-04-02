package com.twingdinesh.twingcovid_19.ui.country;

public class Covidcountry {
    String mcountryname,mcases,mdeath,mtodaysdeath,mtodaycases,mrecover,mcritical,mactive;

    public Covidcountry(String mcountryname, String mcases, String mdeath, String mtodaysdeath, String mtodaycases, String mrecover, String mcritical, String mactive) {
        this.mcountryname = mcountryname;
        this.mcases = mcases;
        this.mdeath = mdeath;
        this.mtodaysdeath = mtodaysdeath;
        this.mtodaycases = mtodaycases;
        this.mrecover = mrecover;
        this.mcritical = mcritical;
        this.mactive=mactive;
    }

    public String getMcountryname() {
        return mcountryname;
    }

    public String getMcases() {
        return mcases;
    }

    public String getMdeath() {
        return mdeath;
    }

    public String getMtodaysdeath() {
        return mtodaysdeath;
    }

    public String getMtodaycases() {
        return mtodaycases;
    }

    public String getMrecover() {
        return mrecover;
    }

    public String getMcritical() {
        return mcritical;
    }

    public String getMactive() {
        return mactive;
    }
}
