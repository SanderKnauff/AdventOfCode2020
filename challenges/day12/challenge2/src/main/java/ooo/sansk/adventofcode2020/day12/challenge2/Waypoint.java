package ooo.sansk.adventofcode2020.day12.challenge2;

public class Waypoint {

    private int posX;
    private int posY;

    public Waypoint(int posX, int posY) {
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

    public void rotate(TurnDirection turnDirection, int degrees) {
        final CardinalDirection rotation = CardinalDirection.getByFacing(degrees * turnDirection.getModifier());
        for (int i = 0; i < (rotation.getDegrees() / 90); i++) {
            int oldX = posX;
            posX = posY;
            posY = -oldX;
        }
    }
}
