package com.simulator.club;

import com.simulator.entity.Player;
import com.simulator.leauge.Leauge;

import java.util.List;


public class Club {
    private String name;
    private List<Player> players;

    public Leauge getCurrentLeauge() {
        return currentLeauge;
    }

    public void setCurrentLeauge(Leauge currentLeauge) {
        this.currentLeauge = currentLeauge;
    }

    private Leauge currentLeauge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Club(String name, List<Player> players){
        this.name = name;
        this.players = players;
    }
    public Club(String name){
        this.name = name;
    }


}
