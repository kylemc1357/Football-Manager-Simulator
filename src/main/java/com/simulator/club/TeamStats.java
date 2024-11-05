package com.simulator.club;

import java.util.LinkedList;

public class TeamStats {
    int rating;
    int morale;
    int form;
    int luck;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    //public void setForm(){}

    public TeamStats(){
        this.rating = 50;  /// 0 - 100
        this.morale = 0;
        this.form = 0;
        this.luck = 50;
    }
}
