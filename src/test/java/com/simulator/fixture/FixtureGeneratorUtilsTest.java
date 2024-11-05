package com.simulator.fixture;

import com.simulator.club.Club;
import com.simulator.week.GameWeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FixtureGeneratorUtilsTest {

    private List<Club> clubs;
    private LocalDate startDate;

    @BeforeEach
    public void setUpClubs(){
        clubs = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            clubs.add(new Club("Club " + i));
        }

        startDate = LocalDate.of(2000,1,1);
    }

    @Test
    public void testGenerateRRHomeFixtures(){
        List<GameWeek> fixtures = FixtureGeneratorUtils.generateRRHomeFixtures(clubs, startDate);

        //test no of game weeks
        assertEquals(11, fixtures.size());

        //check each teams plays each other once
        Set<String> uniqueFixtures = new HashSet<>();
        for(GameWeek week : fixtures){
            for(Fixture fixture : week.getFixtures()){
                String fixtureString = fixture.getHomeTeam().getName() + " vs " + fixture.getAwayTeam().getName();
                assertFalse(uniqueFixtures.contains(fixtureString)); //ensure no same fixture added
                uniqueFixtures.add(fixtureString);
            }
        }
        assertEquals(66, uniqueFixtures.size());   //will equal 66 unique fixtures for 12 teams ( n * (n-1) /2)

        //ensure the last date week is correct
        LocalDate newDate = startDate.plusWeeks(10); //11 weeks but the first week essentially counts as week 0
        assertEquals(newDate, fixtures.get(fixtures.size()-1).getWeekBeginning());
    }

    @Test
    public void testGenerateSecondHalfFixtures() {
        List<GameWeek> firstHalfFixtures = FixtureGeneratorUtils.generateRRHomeFixtures(clubs, startDate);
        List<GameWeek> secondHalfFixtures = FixtureGeneratorUtils.generateSecondRoundFixtures(firstHalfFixtures, startDate.plusWeeks(11));

        //test no of game weeks
        assertEquals(22, secondHalfFixtures.size());

        //check each teams plays each other once both home and away
        Set<String> uniqueFixtures = new HashSet<>();
        for (GameWeek week : secondHalfFixtures) {
            for (Fixture fixture : week.getFixtures()) {
                String fixtureString = fixture.getHomeTeam().getName() + " vs " + fixture.getAwayTeam().getName();
                assertFalse(uniqueFixtures.contains(fixtureString)); //ensure no same fixture added
                uniqueFixtures.add(fixtureString);
            }
        }
        assertEquals(132, uniqueFixtures.size());   //will equal 132 unique fixtures for 12 teams 2 ( n * (n-1) /2)

        //ensure the last date week is correct
        LocalDate newDate = startDate.plusWeeks(21); //22 weeks but the first week essentially counts as week 0
        assertEquals(newDate, secondHalfFixtures.get(secondHalfFixtures.size() - 1).getWeekBeginning());
    }

    @Test
    public void testGenerateThirdRoundFixtures(){
        List<GameWeek> firstHalfFixtures = FixtureGeneratorUtils.generateRRHomeFixtures(clubs, startDate);
        List<GameWeek> secondHalfFixtures = FixtureGeneratorUtils.generateSecondRoundFixtures(firstHalfFixtures, startDate.plusWeeks(11));
        List<GameWeek> thirdRoundFixtures = FixtureGeneratorUtils.generateThirdRoundFixtures(secondHalfFixtures, startDate.plusWeeks(22));

        //test no of game weeks
        assertEquals(33, thirdRoundFixtures.size());

        //check each teams plays each other three times (home, away, random)
        Map<String, Integer> pairedMatchCount = new HashMap<>();
        for (GameWeek week : thirdRoundFixtures) {
            for (Fixture fixture : week.getFixtures()) {
                String homeTeam = fixture.getHomeTeam().getName();
                String awayTeam = fixture.getAwayTeam().getName();
                String pair =(homeTeam.compareTo(awayTeam) < 0) ? homeTeam + " vs " + awayTeam : awayTeam + " vs " + homeTeam;
                pairedMatchCount.put(pair, pairedMatchCount.getOrDefault(pair, 0) + 1);
            }
        }
        assertEquals(66, pairedMatchCount.size());   //will equal 66 set of unique fixtures (home and away irrelvent)

        //each pair should have 3 matches
        for (int count : pairedMatchCount.values()){
            assertEquals(3, count);
        }

        //ensure the last date week is correct
        assertEquals(startDate.plusWeeks(32), thirdRoundFixtures.get(thirdRoundFixtures.size()-1).getWeekBeginning());
    }
}
