package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.potpot.adventofcode2021.util.FileUtils;
import reactor.test.StepVerifier;

public class Day01Test {

    @SneakyThrows
    @ParameterizedTest
    @CsvSource({
            "1, 19",
            "3, 14",
    })
    public void day01part1(int numberOfMeasurements, long expectedResult) {
        var input = FileUtils.getStream("input/day01Test.txt");

        var result = Day01.calculateIncreaseNumber(numberOfMeasurements, input);

        StepVerifier.create(result)
                .expectNext(expectedResult)
                .verifyComplete();
    }
}
