package ooo.sansk.adventofcode2020.day12.challenge2;

public class Ship {

    private int posX;
    private int posY;

    public Ship(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void moveToWaypoint(Waypoint waypoint, int times) {
        posX += waypoint.getPosX() * times;
        posY += waypoint.getPosY() * times;
    }
}
