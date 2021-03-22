package com.example.ht09;

public class Theater {
    String place;
    String id;

    public Theater (String id2, String place2){
        place = place2;
        id = id2;
    }

    public String getName(){
        return place;
    }
    public String getId() {return id;}

    public String toString(){
        return place;
    }

}
