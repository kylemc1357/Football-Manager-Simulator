package com.simulator.fixture;

import com.simulator.club.Club;
import com.simulator.week.GameWeek;

import java.time.LocalDate;
import java.util.List;

public class FixtureGenerator18 implements IFixtureGenerator{

    @Override
    public List<GameWeek> generateFixtures(List<Club> clubs, LocalDate date){
        //generate first half of fixtures on a random basis
        List<GameWeek> fixtures = FixtureGeneratorUtils.generateRRHomeFixtures(clubs, date);
        //then return essentially a duplicate of first half but reveresed (ie Home v Away)
        return FixtureGeneratorUtils.generateSecondRoundFixtures(fixtures, date.plusWeeks(clubs.size() - 1));
    }

}
