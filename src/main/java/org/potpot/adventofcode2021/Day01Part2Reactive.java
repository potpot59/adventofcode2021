package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;

public class Day01Part2Reactive {

    @SneakyThrows
    public static void main(String[] args) {

        var isIncreasedCount = Flux.fromStream(Files.lines(Path.of("input/day01.txt")))
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .buffer(4, 1)
                .filter(previousAndCurrentValue -> previousAndCurrentValue.size() == 4) // we want only 4 values
                .map(previousAndCurrentValue -> previousAndCurrentValue.get(3) > previousAndCurrentValue.get(0)) // currentValue > previousValue
                .filter(isIncreased -> isIncreased)
                .count()
                .block();

        System.out.println(isIncreasedCount);
    }
}
