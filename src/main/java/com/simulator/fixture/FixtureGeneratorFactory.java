package com.simulator.fixture;

public class FixtureGeneratorFactory {

     public enum CompetitionType{
        LEAGUE
    }

    public static IFixtureGenerator getFixtureGenerator(CompetitionType competitionType, int numberOfClubs){
        switch(competitionType){
            case LEAGUE:
                switch(numberOfClubs){
                    case 12:
                        return new FixtureGenerator12();
                    case 18:
                        return new FixtureGenerator18();
                    default:
                        throw new IllegalArgumentException("Invalid number of clubs, does not support this yet.");
                }
            //soon to implement for cups etc
            default:
                throw new IllegalArgumentException("Invalid competition type, code shoudl not reach here.");
        }
    }
}
