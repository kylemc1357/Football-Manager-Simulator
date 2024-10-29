package com.simulator.country;
import com.simulator.leauge.Leauge;
import com.simulator.simulation.SimulationTimeContext;

import java.util.List;
public class Country {
    private String name;
    private List<Leauge> leagues;

    public void runLeagues(SimulationTimeContext timeContext){
        for (Leauge leauge : leagues){
            leauge.runLeauge(timeContext);
        }
    }

    public void removeLeague(Leauge leauge){
        leagues.remove(leauge);
    }
    public void addLeagueToBottom(Leauge leauge){
        leagues.add(leauge);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Leauge> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<Leauge> leagues) {
        this.leagues = leagues;
    }

    public Country(String name, List<Leauge> leagues){
        this.name = name;
        this.leagues = leagues;
    }

}
