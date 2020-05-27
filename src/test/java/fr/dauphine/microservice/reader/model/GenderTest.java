package fr.dauphine.microservice.reader.model;

import org.junit.Before;
import org.junit.Test;

import static fr.dauphine.microservice.reader.model.Gender.F;
import static fr.dauphine.microservice.reader.model.Gender.M;
import static org.junit.Assert.assertEquals;

public class GenderTest {

    Gender gender;

    @Before
    public void setUp() {
        gender = F;
    }

    @Test
    public void testFGender() {
        assertEquals(F, gender);
    }

    @Test
    public void testMGender() {
        gender = M;
        assertEquals(M, gender);
    }

    @Test
    public void testToString() {
        assertEquals("F", gender.toString());
    }

}
