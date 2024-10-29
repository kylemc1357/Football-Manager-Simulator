package com.simulator.week;
import com.simulator.fixture.Fixture;
import com.simulator.simulation.SimulationTimeContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameWeek {

    private int weekNumber;
    private LocalDate weekBeginning;
    private List<Fixture> fixtures;
    public int getWeekNumber() {
        return weekNumber;
    }

    public LocalDate getWeekBeginning() {
        return weekBeginning;
    }
    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public GameWeek(LocalDate weekBeginning, int weekNumber){
        this.weekBeginning = weekBeginning;
        this.fixtures = new ArrayList<>();
        this.weekNumber = weekNumber;
    }
}
