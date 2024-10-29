package com.simulator.simulation;

import java.time.LocalDate;

public class SimulationTimeContext {
    private LocalDate currentDate;
    private int currentRound;

    public SimulationTimeContext(LocalDate startDate) {
        this.currentDate = startDate;
        this.currentRound = 1;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void advanceWeek() {
        currentDate = currentDate.plusWeeks(1);
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void incrementRound() {
        currentRound++;
    }
}
