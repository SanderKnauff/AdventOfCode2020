package ooo.sansk.adventofcode2020.day10.challenge1;

public class Adapter {

    private final int ratedJoltage;

    public Adapter(int ratedJoltage) {
        this.ratedJoltage = ratedJoltage;
    }

    public int getRatedJoltage() {
        return ratedJoltage;
    }

    public boolean canConnect(Adapter other) {
        return Math.abs(ratedJoltage - other.ratedJoltage) <= 3;
    }

    public int calculateJoltageDifference(Adapter other) {
        return Math.abs(ratedJoltage - other.ratedJoltage);
    }

    @Override
    public String toString() {
        return "Adapter{" +
            "ratedJoltage=" + ratedJoltage +
            '}';
    }
}
