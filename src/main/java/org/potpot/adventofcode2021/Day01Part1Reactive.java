package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;

public class Day01Part1Reactive {

    @SneakyThrows
    public static void main(String[] args) {

        var isIncreasedCount = Flux.fromStream(Files.lines(Path.of("input/day01.txt")))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .buffer(2, 1)
                .filter(previousAndCurrentValue -> previousAndCurrentValue.size() == 2) // the last value will be alone, we want only 2 values
                .filter(previousAndCurrentValue -> previousAndCurrentValue.get(1) > previousAndCurrentValue.get(0)) // currentValue > previousValue
                .count()
                .block();

        System.out.println(isIncreasedCount);
    }
}
