package com.nonu.noneumaegi.VO;

import android.graphics.Bitmap;

import java.io.Serializable;

public class MainItemVO implements Serializable {
    private Bitmap icon;
    private String addr;
    private String name;
    private String money;
    private String number;
    int totalperson, joinperson;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
