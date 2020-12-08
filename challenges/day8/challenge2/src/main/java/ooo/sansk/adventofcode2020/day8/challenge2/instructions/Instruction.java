package ooo.sansk.adventofcode2020.day8.challenge2.instructions;

import ooo.sansk.adventofcode2020.day8.challenge2.Memory;

public abstract class Instruction {

    private final int argument;

    public Instruction(int argument) {
        this.argument = argument;
    }

    public int getArgument() {
        return argument;
    }

    public abstract void execute(Memory memory);

    public abstract int getPointerIncrement();

    @Override
    public String toString() {
        return "Instruction{" +
            "argument=" + argument +
            '}';
    }
}
