package ooo.sansk.adventofcode2020.day8.challenge2.instructions;

import ooo.sansk.adventofcode2020.day8.challenge2.Memory;

public class NoOperation extends Instruction {

    public NoOperation(int argument) {
        super(argument);
    }

    @Override
    public void execute(Memory memory) {
    }

    @Override
    public int getPointerIncrement() {
        return 1;
    }

    @Override
    public String toString() {
        return "nop " + getArgument();
    }
}
