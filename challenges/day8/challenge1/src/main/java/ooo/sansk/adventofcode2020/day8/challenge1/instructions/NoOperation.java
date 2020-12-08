package ooo.sansk.adventofcode2020.day8.challenge1.instructions;

import ooo.sansk.adventofcode2020.day8.challenge1.Memory;

public class NoOperation implements Instruction {
    @Override
    public int execute(Memory memory) {
        return 1;
    }
}
