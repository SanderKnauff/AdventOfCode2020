package ooo.sansk.adventofcode2020.day8.challenge1.instructions;

import ooo.sansk.adventofcode2020.day8.challenge1.Memory;

public class Accumulate implements Instruction {

    private final int increment;

    public Accumulate(int increment) {
        this.increment = increment;
    }

    @Override
    public int execute(Memory memory) {
        memory.setMemory(memory.getMemory() + increment);
        return 1;
    }
}
