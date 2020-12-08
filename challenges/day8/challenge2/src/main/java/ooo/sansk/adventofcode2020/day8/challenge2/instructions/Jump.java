package ooo.sansk.adventofcode2020.day8.challenge2.instructions;

import ooo.sansk.adventofcode2020.day8.challenge2.Memory;

public class Jump extends Instruction {

    public Jump(int argument) {
        super(argument);
    }

    @Override
    public void execute(Memory memory) { }

    @Override
    public int getPointerIncrement() {
        return getArgument();
    }

    @Override
    public String toString() {
        return "jmp " + this.getPointerIncrement();
    }
}
