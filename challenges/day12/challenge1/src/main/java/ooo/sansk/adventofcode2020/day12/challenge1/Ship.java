package ooo.sansk.adventofcode2020.day12.challenge1;

public class Ship {

    private CardinalDirection currentDirection;
    private int posX;
    private int posY;

    public Ship(CardinalDirection currentDirection, int posX, int posY) {
        this.currentDirection = currentDirection;
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void move(CardinalDirection direction, int distance) {
        posX += distance * direction.getXModifier();
        posY += distance * direction.getYModifier();
    }

    public void moveForward(int distance) {
        move(currentDirection, distance);
    }

    public void turn(TurnDirection turnDirection, int degrees) {
        currentDirection = CardinalDirection.getByFacing(currentDirection.getDegrees() + (degrees * turnDirection.getModifier()));
    }
}
