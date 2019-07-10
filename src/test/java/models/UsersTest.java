package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNamereturnsName() throws Exception {
        Users testUsers= setupusers();
        assertEquals("Kelvin", testUsers.getName());
    }

    @Test
    public void setName() {
        Users testUsers= setupusers();
        testUsers.setName("Kelvin");
        assertNotEquals("Kariuki", testUsers.getName());
    }

    @Test
    public void getRoleReturnsRole() {
        Users testUsers= setupusers();
        assertEquals("online coding", testUsers.getRole());
    }

    @Test
    public void setRole() {
        Users testUsers= setupusers();
        testUsers.setRole("online coding");
        assertNotEquals("field work", testUsers.getRole());
    }

    @Test
    public void getPositionReturnsPosition() {
        Users testUsers= setupusers();
        assertEquals("CTO", testUsers.getPosition());
    }

    @Test
    public void setPosition() {
        Users testUsers= setupusers();
        testUsers.setPosition("CTO");
        assertNotEquals("software dev", testUsers.getPosition());
    }

    @Test
    public void getIdReturnsId() {

    }

    @Test
    public void setId() {
    }



    //helper
    public  Users setupusers(){
        return new Users("Kelvin","online coding","CTO",1);
    }
}