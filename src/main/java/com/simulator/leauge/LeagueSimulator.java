package com.simulator.leauge;

import com.simulator.club.Club;
import com.simulator.club.TeamStats;
import com.simulator.fixture.Fixture;
import com.simulator.week.GameWeek;


public class LeagueSimulator {

    private Leauge leauge;
    private static int homeAdvantage = 10;

    public LeagueSimulator(Leauge league){
        this.leauge = league;
    }

    public void simulateLeauge(){
        for (GameWeek gameWeek : leauge.getGameWeeks()){
            simulateFixtures(gameWeek);
        }
    }
    private void simulateFixtures(GameWeek gameWeek){
        for (Fixture fixture : gameWeek.getFixtures()){
            simulateGame(fixture);
            System.out.println(fixture.getHomeTeam().getName() + " "  + fixture.getAwayTeam().getName());
        }
    }
    private void simulateGame(Fixture fixture){
        TeamStats homeTeam = fixture.getHomeTeam().getTeamStats();
        TeamStats awayTeam = fixture.getAwayTeam().getTeamStats();

        //logic
        double home = homeTeam.getRating() * skewedRandomMax1_5() + homeTeam.getForm();
        double away = awayTeam.getRating() + awayTeam.getForm();
        int result;
        //calc result
        int homeScore = (int)Math.round(calculateScore(homeTeam, awayTeam) / 8);
        int awayScore = (int)Math.round(calculateScore(awayTeam, homeTeam) / 8);

        //compute corresponding changes
        System.out.println(homeScore + " " + awayScore);

        //update result once i implement a result structure in the fixture
    }

    public static double skewedRandomMax1_5() {
        double u = Math.random();
        double alpha = 3.0;
        return 1 + Math.pow(u, alpha) * 0.5;
    }

    private double calculateScore(TeamStats currentTeam, TeamStats opponent){
        double rating = currentTeam.getRating() - opponent.getRating();
        double form = currentTeam.getForm() - opponent.getForm();
        double morale = currentTeam.getMorale() - opponent.getMorale();

        return (rating + form + morale + homeAdvantage) * skewedRandomMax1_5();
    }

}
