package com.nonu.noneumaegi.VO;

import android.graphics.drawable.Drawable;

public class MainItemVO {
    private Drawable icon, person;
    private String addr;
    private String name;
    private String money;
    private String number;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getPerson() {
        return person;
    }

    public void setPerson(Drawable person) {
        this.person = person;
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

}
