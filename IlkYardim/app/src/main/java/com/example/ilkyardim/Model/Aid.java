package com.example.ilkyardim.Model;

import java.io.Serializable;

public class Aid implements Serializable {
    private String aidName;
    private int imageInt;

    public String getAidName() {
        return aidName;
    }

    public int getImageInt() {
        return imageInt;
    }

    public Aid(String aidName, int imageInt){
        this.aidName = aidName;
        this.imageInt = imageInt;
    }
}
