package com.nonu.noneumaegi.VO;

import android.graphics.drawable.Drawable;

public class Comment {
    boolean isComofcom;
    String nickname;
    String content;
    Drawable img;

    public boolean isComofcom() {
        return isComofcom;
    }

    public void setComofcom(boolean comofcom) {
        isComofcom = comofcom;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
