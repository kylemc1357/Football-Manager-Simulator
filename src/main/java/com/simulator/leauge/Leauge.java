package com.simulator.leauge;
import com.simulator.club.Club;
import com.simulator.simulation.SimulationTimeContext;
import com.simulator.week.GameWeek;
import com.simulator.fixture.FixtureGenerator;


import java.util.List;

public class Leauge {
    private String name;
    private List<Club> clubs;
    private List<GameWeek> gameWeeks;
    private LeaugeTable leaugeTable;

    public void generateFixturesAndTable(SimulationTimeContext timeContext){
        int tableLength = this.clubs.size();
        FixtureGenerator fixtureGenerator  = new FixtureGenerator();
        switch (tableLength){
            case 18:
                this.gameWeeks = fixtureGenerator.generateFixtureFor18TeamLeauge(this.clubs, timeContext.getCurrentDate());
                break;
            case 12:
                this.gameWeeks = fixtureGenerator.generateFixtureFor12TeamLeauge(this.clubs, timeContext.getCurrentDate());
                break;
            default:
                //To be added - but essentially code should never reach here
        }
        this.leaugeTable = new LeaugeTable(this.clubs);
    }
    public void simulateMatchWeeks(){
        //this will go over the match weeks (gameWeeks) and simulate each set of fixtures
        System.out.println(gameWeeks.size());
        for (GameWeek gameWeek : gameWeeks){
            System.out.println("simulating a single game week" + gameWeek.getWeekNumber());
            // i.e gameWeek.getFixtures() - iterate over these and run
        }
    }

    public void runLeauge(SimulationTimeContext date) {
        generateFixturesAndTable(date);
        simulateMatchWeeks();
    }
    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }
    public List<Club> getClubs() {
        return clubs;
    }


    public Leauge(String name){
        this.name = name;
    }
}
