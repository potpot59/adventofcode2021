package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class Day01Part1 {

    @SneakyThrows
    public static void main(String[] args) {

        var previousValue = new AtomicInteger(-1);

        var isIncreasedCount = Files.lines(Path.of("input/day01.txt"))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .map(currentValue -> {
                    var isIncrease = previousValue.get() > 0 && currentValue > previousValue.get();
                    previousValue.set(currentValue);
                    return isIncrease;
                })
                .filter(isIncreased -> isIncreased)
                .count();

        System.out.println(isIncreasedCount);
    }
}
