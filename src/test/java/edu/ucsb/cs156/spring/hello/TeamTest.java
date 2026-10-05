package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_true() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class_returns_false() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_same_name_same_members_returns_true() {
        team.addMember("Sarah");
        Team other = new Team("test-team");
        other.addMember("Sarah");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
        Team other = new Team("test-team");
        other.addMember("Sarah");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_different_name_returns_false() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_equal_teams_have_equal_hashCodes() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    // This test depends on the hashCode implementation. It's here to kill the equivalent mutant that swaps | for &
    @Test
    public void hashCode_returns_expected_value() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
