package com.perscholas.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CohortTest {
    private static Cohort expected;
    @Test
    public void testCohortGetters() {
        expected = new Cohort("Data Analysis with spreadsheets", "8 weeks");
        assertEquals(expected.getcName(), "Data Analysis with spreadsheets");
        assertEquals(expected.getcDuration(), "8 weeks");
    }
}
