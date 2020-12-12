package ooo.sansk.adventofcode2020.day12.challenge2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaypointTest {

    @Test
    void testRotateRight_0() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.RIGHT, 0);

        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }

    @Test
    void testRotateRight_90() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.RIGHT, 90);

        assertEquals(-4, waypoint.getPosX());
        assertEquals(10, waypoint.getPosY());
    }

    @Test
    void testRotateRight_180() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.RIGHT, 180);

        assertEquals(-10, waypoint.getPosX());
        assertEquals(-4, waypoint.getPosY());
    }

    @Test
    void testRotateRight_270() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.RIGHT, 270);

        assertEquals(4, waypoint.getPosX());
        assertEquals(-10, waypoint.getPosY());
    }

    @Test
    void testRotateRight_360() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.RIGHT, 360);

        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }

    @Test
    void testRotateLeft_0() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.LEFT, 0);

        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }

    @Test
    void testRotateLeft_90() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.LEFT, 90);

        assertEquals(4, waypoint.getPosX());
        assertEquals(-10, waypoint.getPosY());
    }

    @Test
    void testRotateLeft_180() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.LEFT, 180);

        assertEquals(-10, waypoint.getPosX());
        assertEquals(-4, waypoint.getPosY());
    }

    @Test
    void testRotateLeft_270() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.LEFT, 270);

        assertEquals(-4, waypoint.getPosX());
        assertEquals(10, waypoint.getPosY());
    }

    @Test
    void testRotateLeft_360() {
        Waypoint waypoint = new Waypoint(10, 4);
        waypoint.rotate(TurnDirection.LEFT, 360);

        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }
}