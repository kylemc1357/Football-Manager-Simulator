package com.simulator.fixture;

import com.simulator.club.Club;
import com.simulator.simulation.SimulationTimeContext;
import com.simulator.week.GameWeek;

import java.time.LocalDate;
import java.util.*;

public class FixtureGenerator {

    public FixtureGenerator(){
    }

    /*public List<GameWeek> generateFixtures(List<Club> clubs){
        int length = clubs.size();
    }*/

    //for 18 team leauges
    /*seen idea online to create one set by anchoring first element and matching up the mirror
    (ie 0 -> end of list, 1 -> end of list -1) and after each loop move the rest of the list
    down one

    i understand this method for now dosent offer compete randomness over the season but will work for now
     */

    //this is functon to create the first set of fixtures, will create a function to generate the
    //other half based on what this returns 
    public List<GameWeek> generateRRHomeFixtures(List<Club> clubs, LocalDate date) { //will only ever get called with even number of teams, either 18 or 12 for now
        List<GameWeek> fixtures = new ArrayList<>();
        Collections.shuffle(clubs);
        int noOfClubs = clubs.size();
        int weekNo = 1;
        Club homeTeam, awayTeam;
        LocalDate weekDate = date;
        for (int h = 0; h < noOfClubs - 1; h++) {
            //each team play each other once so length - 1 times
            GameWeek gameWeek = new GameWeek(weekDate, weekNo ++);
            for (int i = 0; i < (clubs.size() /2 ); i++) {
                //take team from end and team from start and work way inwards
                homeTeam = clubs.get(i);
                awayTeam = clubs.get(noOfClubs - i - 1);
                Fixture fixture = new Fixture(homeTeam, awayTeam);
                gameWeek.getFixtures().add(fixture);
            }
            weekDate = weekDate.plusWeeks(1);
            //add new gameWeek with fxtures to the list of all fixtures
            fixtures.add(gameWeek);
            //rotate list whilst keeping the last element stationary to ensure each team plays each other once
            List<Club> rotatable = clubs.subList(0, noOfClubs - 1);
            Collections.rotate(rotatable, 1);
        }
        return fixtures;
    }
    public List<GameWeek> generateSecondHalfFixtures(List<GameWeek> firstHalfFixtures, LocalDate startdate){
        List<GameWeek> secondHalfFixtures = new ArrayList<>();
        LocalDate weekDate = startdate; //get most recent date from last gameWeek
        int weekNo = firstHalfFixtures.size() +1;
        for (GameWeek previousGameWeek : firstHalfFixtures){
            //iterate over existing gameWeeks, get the fixtures and generate the reversed new fixture (ie Away v Home)
            GameWeek currrentGameWeek = new GameWeek(weekDate, weekNo ++);
            for (Fixture previousFixture : previousGameWeek.getFixtures()){
                Fixture newFixture = new Fixture(previousFixture.getAwayTeam(), previousFixture.getHomeTeam());
                currrentGameWeek.getFixtures().add(newFixture);
            }
            secondHalfFixtures.add(currrentGameWeek);
            weekDate = weekDate.plusWeeks(1);
        }
        //return a list of all the combined GameWeeks
        List<GameWeek> combinedFixtures = new ArrayList<>(firstHalfFixtures);
        combinedFixtures.addAll(secondHalfFixtures);
        return combinedFixtures;
    };
    public List<GameWeek> generateThirdRoundFixtures(List<GameWeek> firstTwoRoundFixtures, LocalDate startDate){ //for teams of 12 when they play each other 3 times
        int halfwayIndex = firstTwoRoundFixtures.size()/2;
        LocalDate weekDate = startDate;
        List<GameWeek> thirdRoundFixtures = new ArrayList<>();
        int weekNo = firstTwoRoundFixtures.size() +1;
        for(int i = halfwayIndex; i < firstTwoRoundFixtures.size(); i++){
            GameWeek previousGameWeek = firstTwoRoundFixtures.get(i);
            GameWeek currrentGameWeek = new GameWeek(weekDate, weekNo + 1);
            for(Fixture previousFixture : previousGameWeek.getFixtures()){
                Fixture newFixture = new Fixture(previousFixture.getAwayTeam(), previousFixture.getHomeTeam());
                currrentGameWeek.getFixtures().add(newFixture);
            }
            thirdRoundFixtures.add(currrentGameWeek);
            weekDate = weekDate.plusWeeks(1);
        }
        List<GameWeek> combinedFixtures = new ArrayList<>(firstTwoRoundFixtures);
        combinedFixtures.addAll(thirdRoundFixtures);
        return combinedFixtures;
    }

    public List<GameWeek> generateFixtureFor18TeamLeauge(List<Club> clubs, LocalDate startDate){
        return generateSecondHalfFixtures(generateRRHomeFixtures(clubs, startDate), startDate.plusWeeks(clubs.size() - 1));

    }
    public List<GameWeek> generateFixtureFor12TeamLeauge(List<Club> clubs, LocalDate startDate){
        return generateThirdRoundFixtures(generateSecondHalfFixtures(generateRRHomeFixtures(clubs, startDate), startDate.plusWeeks(clubs.size() - 1)), startDate.plusWeeks(2 * (clubs.size() - 1)));
    }

    public Date addWeekToDate(Date date){  //takes a date and returns a week after
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        return calendar.getTime();
    }

    /*public GameWeek iterateOverGameWeekAndReturnGameWeekWithReversedFixtures(GameWeek previousGameWeek){

    }*/

}
