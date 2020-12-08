package ooo.sansk.adventofcode2020.day8.challenge1.instructions;

import ooo.sansk.adventofcode2020.day8.challenge1.Memory;

public class Jump implements Instruction {

    private final int increment;

    public Jump(int increment) {
        this.increment = increment;
    }

    @Override
    public int execute(Memory memory) {
        return increment;
    }
}
