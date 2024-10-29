package com.simulator.fixture;
import com.simulator.club.Club;

public class Fixture {
    private Club homeTeam;
    private Club awayTeam;
    public Fixture(Club homeTeam, Club awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    public void setHomeTeam(Club homeTeam) {
        this.homeTeam = homeTeam;
    }
    public Club getHomeTeam() {
        return homeTeam;
    }
    public void setAwayTeam(Club awayTeam) {
        this.awayTeam = awayTeam;
    }
    public Club getAwayTeam() {
        return awayTeam;
    }
}
