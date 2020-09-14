package com.example.gadsleaderboard;

public class ListLearners {
    private String name;
    private String hours;
    private String country;



    public ListLearners(String leanerName, String leanerHour, String learnerCountry) {
        this.name = leanerName;
        this.hours = leanerHour;
        this.country = learnerCountry;
    }



    public String getLeanerName() {
        return name;
    }


    public String getLeanerHour() {
        return hours;
    }


    public String getLearnerCountry() {
        return country;
    }

}
