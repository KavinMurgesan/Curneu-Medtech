package com.example.kavin.curneu;

public class ticket {
    String id;
    String staName;
    String staNo;

    public ticket(){

    }

    public ticket(String id, String staName, String staNo) {
        this.id = id;
        this.staName = staName;
        this.staNo = staNo;
    }

    public String getId() {
        return id;
    }

    public String getStaName() {
        return staName;
    }

    public String getStaNo() {
        return staNo;
    }
}
