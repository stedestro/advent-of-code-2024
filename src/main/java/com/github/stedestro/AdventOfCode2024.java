package com.github.stedestro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.github.stedestro.day01.AOCDay01;
import com.github.stedestro.day02.AOCDay02;
import com.github.stedestro.day03.AOCDay03;

public class AdventOfCode2024 {
    public static void main(String[] args) {
        var day = args[0];
        var inputfile = args[1];

        System.out.println("Day " + day + " with file " + inputfile);
        System.out.println();
        List<String> input;
        try {
            input = loadInput(Paths.get(inputfile));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        switch (day) {
            case "01":
                System.out.println("Answer 01: " + AOCDay01.runPart1(input));
                break;
            case "01b":
                System.out.println("Answer 01b: " + AOCDay01.runPart2(input));
                break;
            case "02":
                System.out.println("Answer 02: " + AOCDay02.runPart1(input));
                break;
            case "02b":
                System.out.println("Answer 02b: " + AOCDay02.runPart2(input));
                break;
            case "03":
                System.out.println("Answer 03: " + AOCDay03.runPart1(input));
                break;
            case "03b":
                System.out.println("Answer 03b: " + AOCDay03.runPart2(input));
                break;
            default:
                break;
        }
    }

    private static List<String> loadInput(Path inputFile) throws IOException {
        return Files.readAllLines(inputFile);
    }

}
