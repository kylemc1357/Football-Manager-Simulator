package com.simulator.fixture;

import com.simulator.club.Club;
import com.simulator.week.GameWeek;

import java.time.LocalDate;
import java.util.List;

public interface IFixtureGenerator {
    //interface generates a list of GameWeeks (each containing a list of fixtures) for a given list of clubs
    List<GameWeek> generateFixtures(List<Club> clubs, LocalDate date);

}
