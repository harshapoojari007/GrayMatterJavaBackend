package com.grayMatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.*;
 
public class AppTest {
 
    private PersonImplementation pi;
    private Connection connection;
 
    @BeforeEach
    void setUp() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/graymatter", "root", "password");
        pi = new PersonImplementation();
    }
 
    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
 
    @Test
    void testGetAllPersons() throws SQLException, ClassNotFoundException {
        List<Person> persons = pi.getAllPeronsInfo();
        assertNotNull(persons);
        assertTrue(persons.size() > 0, "Should return at least one person");
    }
 
    @Test
    void testGetPersonById() throws SQLException, ClassNotFoundException {
        Person person = pi.getPersonById(3);
        assertNotNull(person);
        assertEquals(3, person.getId());
        assertEquals("Jim Brown", person.getName());
    }
 
    @Test
    void testAddPerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(101,"adi", 22,"testkiran@gmail.com");
        Person addedPerson = pi.addPerson(person);
        assertEquals(person.getName(), addedPerson.getName());
    }
 
    @Test
    void testUpdatePerson() throws SQLException, ClassNotFoundException {
        Person person = new Person(101,"adi", 22,"testkiran@gmail.com");
        Person updatedPerson = pi.updatePerson(person);
        assertNotNull(updatedPerson);
        assertEquals(person.getName(), updatedPerson.getName());
    }
 
    @Test
    void testDeletePerson() throws SQLException, ClassNotFoundException {
        Person person = pi.deletePerson(101);
        assertEquals(101, person.getId());
    }
}
 