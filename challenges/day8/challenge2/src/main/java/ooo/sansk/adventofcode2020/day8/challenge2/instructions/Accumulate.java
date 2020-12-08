package ooo.sansk.adventofcode2020.day8.challenge2.instructions;

import ooo.sansk.adventofcode2020.day8.challenge2.Memory;

public class Accumulate extends Instruction {

    public Accumulate(int argument) {
        super(argument);
    }

    @Override
    public void execute(Memory memory) {
        memory.setMemory(memory.getMemory() + this.getArgument());
    }

    @Override
    public int getPointerIncrement() {
        return 1;
    }


}
