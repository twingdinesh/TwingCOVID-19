package com.twingdinesh.twingcovid_19.ui.india;

public class indiahelperclass {

    String statename,statedeath,staterecover,statecases;

    public indiahelperclass(String statename, String statedeath, String staterecover, String statecases) {
        this.statename = statename;
        this.statedeath = statedeath;
        this.staterecover = staterecover;
        this.statecases = statecases;
    }

    public String getStatename() {
        return statename;
    }

    public String getStatedeath() {
        return statedeath;
    }

    public String getStaterecover() {
        return staterecover;
    }

    public String getStatecases() {
        return statecases;
    }
}
