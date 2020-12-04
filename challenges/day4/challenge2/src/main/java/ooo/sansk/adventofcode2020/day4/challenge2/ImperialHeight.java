package ooo.sansk.adventofcode2020.day4.challenge2;

public class ImperialHeight extends Height {

    public ImperialHeight(int height) {
        super(height);
    }

    @Override
    public boolean isValid() {
        return this.getHeight() >= 59 && this.getHeight() <= 76 ;
    }

    @Override
    public String toString() {
        return getHeight() + "in";
    }
}
