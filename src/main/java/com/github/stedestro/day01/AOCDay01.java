package com.github.stedestro.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AOCDay01 {
    
    public static Integer runPart1(List<String> input) {
        AOCDay01Input structuredInput = getInput(input);

        structuredInput.leftList().sort(null);
        structuredInput.rightList().sort(null);

        var sum = 0;
        for(int i = 0; i < structuredInput.leftList().size(); i++) {
            sum = sum + Math.abs(structuredInput.leftList().get(i) - structuredInput.rightList().get(i));
        }
        return sum;
    }

    public static Integer runPart2(List<String> input) {
        AOCDay01Input structuredInput = getInput(input);

        var occurences = new HashMap<Integer, Integer>();

        var sum = 0;

        for(Integer key : structuredInput.leftList) {
            if(occurences.containsKey(key)) {
                sum = sum + (key * occurences.get(key));
            } else {
                occurences.put(key, Collections.frequency(structuredInput.rightList(), key));
                sum = sum + (key * occurences.get(key));
            }
        }

        return sum;
    }

    private record AOCDay01Input(
        List<Integer> leftList,
        List<Integer> rightList
    ) {}

    private static AOCDay01Input getInput(List<String> input) {
        List<Integer> listLeft = new ArrayList<Integer>();
        List<Integer> listRight = new ArrayList<Integer>();
        
        for(int i = 0; i < input.size(); i++) {
            var splitted = input.get(i).split("   ");
            listLeft.add(Integer.valueOf(splitted[0]));
            listRight.add(Integer.valueOf(splitted[1]));
        }

        return new AOCDay01Input(listLeft, listRight);
    }

}
