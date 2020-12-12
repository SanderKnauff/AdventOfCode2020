package ooo.sansk.adventofcode2020.day12.challenge2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StepTest {

    @Test
    void stepOne_F10() {
        Ship ship = new Ship(0, 0);
        Waypoint waypoint = new Waypoint(10 ,1);

        ship.moveToWaypoint(waypoint, 10);

        assertEquals(100, ship.getPosX());
        assertEquals(10, ship.getPosY());
        assertEquals(10, waypoint.getPosX());
        assertEquals(1, waypoint.getPosY());
    }

    @Test
    void stepTwo_N3() {
        Ship ship = new Ship(100, 10);
        Waypoint waypoint = new Waypoint(10 ,1);

        waypoint.move(CardinalDirection.NORTH, 3);

        assertEquals(100, ship.getPosX());
        assertEquals(10, ship.getPosY());
        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }

    @Test
    void stepThree_F7() {
        Ship ship = new Ship(100, 10);
        Waypoint waypoint = new Waypoint(10 ,4);

        ship.moveToWaypoint(waypoint, 7);

        assertEquals(170, ship.getPosX());
        assertEquals(38, ship.getPosY());
        assertEquals(10, waypoint.getPosX());
        assertEquals(4, waypoint.getPosY());
    }

    @Test
    void stepFour_R90() {
        Ship ship = new Ship(170, 38);
        Waypoint waypoint = new Waypoint(10 ,4);

        waypoint.rotate(TurnDirection.RIGHT, 90);

        assertEquals(170, ship.getPosX());
        assertEquals(38, ship.getPosY());
        assertEquals(4, waypoint.getPosX());
        assertEquals(-10, waypoint.getPosY());
    }

    @Test
    void stepFive_F11() {
        Ship ship = new Ship(170, 38);
        Waypoint waypoint = new Waypoint(4 ,-10);

        ship.moveToWaypoint(waypoint, 11);

        assertEquals(214, ship.getPosX());
        assertEquals(-72, ship.getPosY());
        assertEquals(4, waypoint.getPosX());
        assertEquals(-10, waypoint.getPosY());
    }
}
