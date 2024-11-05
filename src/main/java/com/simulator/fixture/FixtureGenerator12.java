package com.simulator.fixture;

import com.simulator.club.Club;
import com.simulator.week.GameWeek;

import java.time.LocalDate;
import java.util.List;

public class FixtureGenerator12 implements  IFixtureGenerator{

    @Override
    public List<GameWeek> generateFixtures(List<Club> clubs, LocalDate date){
        List <GameWeek> firstSetOfFixtures = FixtureGeneratorUtils.generateRRHomeFixtures(clubs, date);
        List <GameWeek> secondSetPlusFirstSet = FixtureGeneratorUtils.generateSecondRoundFixtures(firstSetOfFixtures, date.plusWeeks(clubs.size() - 1));
        return FixtureGeneratorUtils.generateThirdRoundFixtures(secondSetPlusFirstSet, date.plusWeeks(2 * (clubs.size() - 1)));
    }
}
