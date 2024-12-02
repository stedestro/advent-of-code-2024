package com.github.stedestro.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AOCDay02 {
    private record AOCDay02Input(
            List<List<Integer>> levels) {
    }

    private static AOCDay02Input getInput(List<String> input) {
        List<List<Integer>> levels = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            levels.add(
                    Arrays.asList(input.get(i).split(" "))
                            .stream().map(Integer::valueOf).toList());
        }

        return new AOCDay02Input(levels);
    }

    private static Boolean computeLevel(List<Integer> level) {
        var isRaising = level.get(1) > level.get(0);

        for (int i = 1; i < level.size(); i++) {
            var nbCurrent = level.get(i);
            var nbPrevious = level.get(i - 1);

            if(nbCurrent == nbPrevious) {
                return false;
            }

            var currentIsRaising = nbCurrent > nbPrevious;

            if ((isRaising && !currentIsRaising)
                    || (!isRaising && currentIsRaising)) {
                return false;
            }

            Integer diff = nbCurrent - nbPrevious;

            if ((isRaising && !(diff > 0 && diff < 4))
                || (!isRaising && !(diff > -4 && diff < 0))) {
                return false;
            }
        }

        return true;
    }

    public static Integer runPart1(List<String> input) {
        var structuredInput = getInput(input);

        return structuredInput.levels()
            .stream()
            .map((level) -> {
                return computeLevel(level) ? 1 : 0;
            })
            .collect(Collectors.summingInt(Integer::intValue));
    }

    public static Integer runPart2(List<String> input) {
        var structuredInput = getInput(input);

        var sumSafe = 0;
        
        for(List<Integer> level : structuredInput.levels) {
            if(computeLevel(level)) {
                sumSafe = sumSafe + 1;
            } else {
                for(int i = 0; i < level.size(); i++) {
                    var copy = new ArrayList<>(level);
                    copy.remove(i);
                    if(computeLevel(copy)) {
                        sumSafe = sumSafe + 1;
                        break;
                    }
                }
            }
        }

        return sumSafe;
    }
}
