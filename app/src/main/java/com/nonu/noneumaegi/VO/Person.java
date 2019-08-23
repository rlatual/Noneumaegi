package com.nonu.noneumaegi.VO;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Person implements Serializable {
    int totalperson, joinperson;

    public int getTotalperson() {
        return totalperson;
    }

    public void setTotalperson(int totalperson) {
        this.totalperson = totalperson;
    }

    public int getJoinperson() {
        return joinperson;
    }

    public void setJoinperson(int joinperson) {
        this.joinperson = joinperson;
    }
}
