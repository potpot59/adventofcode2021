package org.potpot.adventofcode2021;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.potpot.adventofcode2021.util.FileUtils;
import reactor.test.StepVerifier;

public class Day02Test {

    @SneakyThrows
    @Test
    public void day02part1() {
        var input = FileUtils.getStream("input/day02Test.txt");

        var result = Day02.calculateHorizontalPositionAndDepthPart1(input);

        StepVerifier.create(result)
                .expectNext(150L)
                .verifyComplete();
    }

    @SneakyThrows
    @Test
    public void day02part2() {
        var input = FileUtils.getStream("input/day02Test.txt");

        var result = Day02.calculateHorizontalPositionAndDepthPart2(input);

        StepVerifier.create(result)
                .expectNext(900L)
                .verifyComplete();
    }
}
