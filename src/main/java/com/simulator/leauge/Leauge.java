package com.simulator.leauge;
import com.simulator.club.Club;
import com.simulator.fixture.FixtureGeneratorFactory;
import com.simulator.fixture.IFixtureGenerator;
import com.simulator.simulation.SimulationTimeContext;
import com.simulator.week.GameWeek;


import java.util.List;

public class Leauge {
    private String name;
    private List<Club> clubs;

    public List<GameWeek> getGameWeeks() {
        return gameWeeks;
    }

    public void setGameWeeks(List<GameWeek> gameWeeks) {
        this.gameWeeks = gameWeeks;
    }

    private List<GameWeek> gameWeeks;
    private LeaugeTable leaugeTable;

    public void generateFixturesAndTable(SimulationTimeContext timeContext){
        int tableLength = this.clubs.size();
        IFixtureGenerator fixtureGenerator = FixtureGeneratorFactory.getFixtureGenerator(FixtureGeneratorFactory.CompetitionType.LEAGUE, clubs.size());
        this.gameWeeks = fixtureGenerator.generateFixtures(this.clubs, timeContext.getCurrentDate());
        this.leaugeTable = new LeaugeTable(this.clubs);
    }

    public void runLeauge(SimulationTimeContext date) {
        generateFixturesAndTable(date);
        LeagueSimulator leagueSimulator = new LeagueSimulator(this);
        leagueSimulator.simulateLeauge();
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
