package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class Day01Part2 {

    @SneakyThrows
    public static void main(String[] args) {

        var previousValue1 = new AtomicInteger(-1);
        var previousValue2 = new AtomicInteger(-1);
        var previousValue3 = new AtomicInteger(-1);

        var isIncreasedCount = Files.lines(Path.of("input/day01.txt"))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .map(currentValue -> {
                    var isIncreased = previousValue1.get() > 0 && previousValue2.get() > 0 && previousValue3.get() > 0
                            && currentValue > previousValue1.get(); // we only need to compare D > A, thx @ybadache;
                    previousValue1.set(previousValue2.get());
                    previousValue2.set(previousValue3.get());
                    previousValue3.set(currentValue);
                    return isIncreased;
                })
                .filter(isIncreased -> isIncreased)
                .count();

        System.out.println(isIncreasedCount);
    }
}
