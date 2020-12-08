package ooo.sansk.adventofcode2020.day8.challenge2;

import ooo.sansk.adventofcode2020.day8.challenge2.instructions.Accumulate;
import ooo.sansk.adventofcode2020.day8.challenge2.instructions.Instruction;
import ooo.sansk.adventofcode2020.day8.challenge2.instructions.Jump;
import ooo.sansk.adventofcode2020.day8.challenge2.instructions.NoOperation;

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

        nonLoopBruteforcer(instructions, 0, new Memory(0), new HashSet<>(), -1);
    }

    public static void nonLoopBruteforcer(List<Instruction> instructions, int currentPointer, Memory currentMemory, Set<Integer> visitedInstructions, int changedInstruction) {
        if (currentPointer == instructions.size()) {
            System.out.println("Got to the end with accumulated value " + currentMemory.getMemory() + ". Turns out the '" + changedInstruction + ":" + instructions.get(changedInstruction) + "' was the problem all along...");
            System.out.println("Stack: " + visitedInstructions.toString());
            return;
        }
        if (visitedInstructions.contains(currentPointer)) {
            return;
        }
        visitedInstructions.add(currentPointer);
        Instruction instruction = instructions.get(currentPointer);
        instruction.execute(currentMemory);
        if (instruction instanceof NoOperation) {
            if(changedInstruction == -1) {
                nonLoopBruteforcer(instructions, currentPointer + instruction.getArgument(), new Memory(currentMemory.getMemory()), new HashSet<>(visitedInstructions), currentPointer);
            }
            nonLoopBruteforcer(instructions, currentPointer + 1, new Memory(currentMemory.getMemory()), new HashSet<>(visitedInstructions), changedInstruction);
            return;
        } else if (instruction instanceof Jump) {
            if (changedInstruction == -1) {
                nonLoopBruteforcer(instructions, currentPointer + 1, new Memory(currentMemory.getMemory()), new HashSet<>(visitedInstructions), currentPointer);
            }
            nonLoopBruteforcer(instructions, currentPointer + instruction.getPointerIncrement(), new Memory(currentMemory.getMemory()), new HashSet<>(visitedInstructions), changedInstruction);
            return;
        }
        nonLoopBruteforcer(instructions, currentPointer + 1, currentMemory, visitedInstructions, changedInstruction);
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
        final int argument = Integer.parseInt(tokens[1]);
        return switch (tokens[0]) {
            case "nop" -> new NoOperation(argument);
            case "acc" -> new Accumulate(argument);
            case "jmp" -> new Jump(argument);
            default -> null;
        };
    }
}
