package com.simulator.leauge;
import com.simulator.club.Club;
public class LeaugeTableEntry {
    private Club club;
    private int gamesPlayed;
    private int wins;
    private int draws;
    private int losses;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private int points;
    private int goalDifference;

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public LeaugeTableEntry(Club club){
        this.club = club;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
        this.points = 0;
        this.goalDifference = 0;
    }

    public void updateResult(int result){
        gamesPlayed ++;
        //result represents the number of goals won/lost by
        //+ve == win, 0 == draw, -ve == loss
        //+2 means won by 2 goals so +2 to goal difference and +3 to points
        //-4 mean lost by 4 goals so -4 to goal difference and +0 points
        if (result > 0){
            wins ++;
            points += 3;
            goalDifference += result;
        } else if (result < 0) {
            losses ++;
            goalDifference -= result;
        } else {
            draws ++;
            points ++;
        }
        }
    }
