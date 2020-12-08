package ooo.sansk.adventofcode2020.day8.challenge1;

import ooo.sansk.adventofcode2020.day8.challenge1.instructions.Accumulate;
import ooo.sansk.adventofcode2020.day8.challenge1.instructions.Instruction;
import ooo.sansk.adventofcode2020.day8.challenge1.instructions.Jump;
import ooo.sansk.adventofcode2020.day8.challenge1.instructions.NoOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Instruction> instructions = readInstructionsFromFile();

        Set<Integer> visted = new HashSet<>();
        Memory memory = new Memory(0);
        int pointer = 0;

        while (!visted.contains(pointer)) {
            visted.add(pointer);
            pointer += instructions.get(pointer).execute(memory);
        }

        System.out.println("The accumulated value before the first loop was " + memory.getMemory());
    }

    private static List<Instruction> readInstructionsFromFile() {
        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            return stream.map(Main::parseInstruction)
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private static Instruction parseInstruction(String instruction) {
        String[] tokens = instruction.split("\\s+");
        if (tokens.length != 2) {
            System.out.println("Invalid instruction! '" + instruction + "'");
            return null;
        }
        return switch (tokens[0]) {
            case "nop" -> new NoOperation();
            case "acc" -> new Accumulate(Integer.parseInt(tokens[1]));
            case "jmp" -> new Jump(Integer.parseInt(tokens[1]));
            default -> null;
        };
    }
}
