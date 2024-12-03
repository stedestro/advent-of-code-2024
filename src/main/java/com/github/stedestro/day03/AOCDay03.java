package com.github.stedestro.day03;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AOCDay03 {
    
    public static Integer runPart1(List<String> input) {
        String code = input.stream().collect(Collectors.joining("\n"));

        String pattern = "mul\\((\\d+)\\,(\\d+)\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(code);

        var sum = 0;
        while (matcher.find()) {
            Integer x = Integer.valueOf(matcher.group(1));
            Integer y = Integer.valueOf(matcher.group(2));
            sum = sum + (x * y);
        }

        return sum;
    }

    public static Integer runPart2(List<String> input) {
        String code = input.stream().collect(Collectors.joining("\n"));

        String pattern = "mul\\((\\d+)\\,(\\d+)\\)|do\\(\\)|don't\\(\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(code);

        var sum = 0;
        var doMul = true;
        while (matcher.find()) {
            if (matcher.group(1) != null && doMul) {
                Integer x = Integer.valueOf(matcher.group(1));
                Integer y = Integer.valueOf(matcher.group(2));
                sum = sum + (x * y);
            } else {
                doMul = matcher.group().equals("do()");
            }
        }

        return sum;
    }
}
