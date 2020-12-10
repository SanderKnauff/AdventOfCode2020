package ooo.sansk.adventofcode2020.day10.challenge2;

public class Adapter {

    private long arrangements;
    private final int ratedJoltage;

    public Adapter(long arrangements, int ratedJoltage) {
        this.arrangements = arrangements;
        this.ratedJoltage = ratedJoltage;
    }

    public boolean canConnect(Integer ratedJoltage) {
        return Math.abs(this.ratedJoltage - ratedJoltage) <= 3;
    }

    public long getArrangements() {
        return arrangements;
    }
}
