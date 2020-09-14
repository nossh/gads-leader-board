package com.example.gadsleaderboard;

public class ListSkillIQ {
    private String name;
    private String score;
    private String country;



    public ListSkillIQ(String leanerName, String leanerScore, String learnerCountry) {
        this.name = leanerName;
        this.score = leanerScore;
        this.country = learnerCountry;
    }



    public String getLeanerName() {
        return name;
    }

    public String getLeanerScore() {
        return score;
    }

    public String getLearnerCountry() {
        return country;
    }

}
