package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import reactor.test.StepVerifier;

import java.nio.file.Files;
import java.nio.file.Path;

public class Day01Test {

    @SneakyThrows
    @ParameterizedTest
    @CsvSource({
            "1, 19",
            "3, 14",
    })
    public void day01part1(int numberOfMeasurements, long expectedResult) {
        var input = Files.lines(Path.of("input/day01Test.txt"));

        var result = Day01.calculateIncreaseNumber(numberOfMeasurements, input);

        StepVerifier.create(result)
                .expectNext(expectedResult)
                .verifyComplete();
    }

}
