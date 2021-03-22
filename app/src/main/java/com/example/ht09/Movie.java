package com.example.ht09;

public class Movie {
    String name;
    String id;
    String date;


    public Movie (String id2, String name2, String date2){
        name = name2;
        id = id2;
        date = date2;
    }

    public String getName(){
        return name;
    }
    public String getId() {return id;}
    public String getdate() {return date;}

    public String toString() {

        return name +" "+date;
    }

}
