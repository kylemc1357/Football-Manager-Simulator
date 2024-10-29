package com.simulator.simulation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.simulator.country.Country;
import com.simulator.leauge.Leauge;
import com.simulator.club.Club;

public class Simulation
{
    private List<Country> countries;
    private SimulationTimeContext simulationTimeContext;
    public void addCountry(Country country){
        countries.add(country);
    }
    public Simulation(LocalDate date){
        this.countries = new ArrayList<Country>();
        this.simulationTimeContext = new SimulationTimeContext(date);
    }
    public static void main( String[] args )
    {
        LocalDate date = LocalDate.of(2000,1,1);
        Simulation simulation = new Simulation(date);
        Leauge test1 = new Leauge( "test1");

        List<Club> clubs = new ArrayList<>();
        for (char i = 'A'; i < 'S'; i++) { //generate 18 clubs of test names
            clubs.add(new Club("club" + i));
        }
        test1.setClubs(clubs);
        test1.generateFixturesAndTable(simulation.simulationTimeContext);
        test1.runLeauge(simulation.simulationTimeContext);
        System.out.println("works");
    }

}
