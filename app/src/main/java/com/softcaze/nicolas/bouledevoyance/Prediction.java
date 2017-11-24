package com.softcaze.nicolas.bouledevoyance;

/**
 * Created by Nicolas on 20/11/2017.
 */

public class Prediction {
    int id;
    String txt;
    int dejaLu;

    Prediction(int i, String t, int b){
        this.id = i;
        this.txt = t;
        this.dejaLu = b;
    }

    public int getDejaVu() {
        return dejaLu;
    }

    public int getId() {
        return id;
    }

    public String getTxt() {
        return txt;
    }

    public void setDejaVu(int dejaLu) {
        this.dejaLu = dejaLu;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setId(int id) {
        this.id = id;
    }
}
