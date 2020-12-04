package ooo.sansk.adventofcode2020.day4.challenge2;

public abstract class Height {

    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public abstract boolean isValid();
}
