package ooo.sansk.adventofcode2020.day4.challenge2;

public class MetricHeight extends Height {

    public MetricHeight(int height) {
        super(height);
    }

    @Override
    public boolean isValid() {
        return this.getHeight() >= 150 && this.getHeight() <= 193 ;
    }

    @Override
    public String toString() {
        return getHeight() + "cm";
    }
}
