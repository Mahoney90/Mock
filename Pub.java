package com.mahoneyapps.tapitfinal;

/**
 * Created by Brendan on 3/6/2016.
 */
public class Pub {
    String mName;

    public Pub(String name){
        this.mName = name;
    }

    public void setPubName(String name){
        this.mName = name;
    }

    public String getPubName(){
        return mName;
    }
}
