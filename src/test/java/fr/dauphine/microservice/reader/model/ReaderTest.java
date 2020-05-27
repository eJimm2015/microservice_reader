package fr.dauphine.microservice.reader.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReaderTest {

    Reader reader;

    @Before
    public void setUp() {
        reader = new Reader();
    }

    @Test
    public void testIdSetterAndGetter() {
        reader.setId(12345);
        assertEquals(Integer.valueOf(12345), reader.getId());
    }

    @Test
    public void testAddressSetterAndGetter() {
        reader.setAddress("15 rue Hocine, 75001 Paris");
        assertEquals("15 rue Hocine, 75001 Paris", reader.getAddress());
    }

    @Test
    public void testBirthDateSetterAndGetter() {
        Date d  = new Date();
        reader.setBirthDate(d);
        assertEquals(d, reader.getBirthDate());
    }

    @Test
    public void testFamilyNameSetterAndGetter() {
        reader.setFamilyName("Hamiho");
        assertEquals("Hamiho", reader.getFamilyName());
    }

    @Test
    public void testFirstNameSetterAndGetter() {
        reader.setFirstName("Hoho");
        assertEquals("Hoho", reader.getFirstName());
    }

    @Test
    public void testSetterAndGetter() {
        reader.setGender(Gender.F);
        assertEquals(Gender.F, reader.getGender());
    }

    @Test
    public void testEquals() {
        Reader reader1 = new Reader();
        reader.setId(12345);
        reader1.setId(12345);
        assertEquals(reader, reader1);
    }

    @Test
    public void testNotEquals() {
        Reader reader1 = new Reader();
        reader.setId(12345);
        reader1.setId(12354);
        assertNotEquals(reader1, reader);
    }

    @Test
    public void testSameHashcode() {
        Reader reader1 = new Reader();
        reader.setId(12345);
        reader1.setId(12345);
        assertEquals(reader.hashCode(), reader1.hashCode());
    }

    @Test
    public void testNotSameHashcode() {
        Reader reader1 = new Reader();
        reader.setId(12345);
        reader1.setId(12354);
        assertNotEquals(reader1.hashCode(), reader.hashCode());
    }

    @Test
    public void testNotEmptyToString() {
        assertNotEquals("", reader.toString());
    }
}
