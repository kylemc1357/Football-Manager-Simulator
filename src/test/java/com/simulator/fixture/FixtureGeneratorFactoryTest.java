package com.simulator.fixture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixtureGeneratorFactoryTest {

    @Test
    public void testGetFixtureGenerator_FixtureGenerator18() {
        IFixtureGenerator result = FixtureGeneratorFactory.getFixtureGenerator(FixtureGeneratorFactory.CompetitionType.LEAGUE, 18);
        assertTrue(result instanceof FixtureGenerator18);
    }

    @Test
    public void testGetFixtureGenerator_FixtureGenerator12() {
        IFixtureGenerator result = FixtureGeneratorFactory.getFixtureGenerator(FixtureGeneratorFactory.CompetitionType.LEAGUE, 12);
        assertTrue(result instanceof FixtureGenerator12);
    }
}
