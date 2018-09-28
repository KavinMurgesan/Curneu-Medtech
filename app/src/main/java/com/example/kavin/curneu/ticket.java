package com.example.kavin.curneu;

public class ticket {
    String id;
    String staName;
    String staNo;
    String uname;
    String usercon;
    String userId;
    int fare;

    public ticket(){

    }

    public ticket(String userId,String uname, String usercon, int fare) {
        this.uname = uname;
        this.usercon = usercon;
        this.userId = userId;
        this.fare = fare;
    }

    public ticket(String id, String staName, String staNo) {
        this.id = id;
        this.staName = staName;
        this.staNo = staNo;
    }

    public String getUname() {
        return uname;
    }

    public String getUsercon() {
        return usercon;
    }

    public String getUserId() {
        return userId;
    }

    public int getFare() {
        return fare;
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

