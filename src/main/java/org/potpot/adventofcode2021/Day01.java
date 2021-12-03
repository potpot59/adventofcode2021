package org.potpot.adventofcode2021;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.potpot.adventofcode2021.util.FileUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@UtilityClass
public class Day01 {

    public static Mono<Long> calculateIncreaseNumber(int numberOfMeasurements, Stream<String> input) {
        return Flux.fromStream(input)
                .filter(StringUtils::isNotBlank)
                .map(Integer::parseInt)
                .buffer(numberOfMeasurements + 1, 1)
                // we only continue if we have all the values (skip last elements)
                .filter(previousAndCurrentValue -> previousAndCurrentValue.size() == numberOfMeasurements + 1)
                // to compare B+C > A+B, we just have to compare C > A
                // to compare B+C+D > A+B+C, we just have to compare D > A
                // to compare B+C+D+E > A+B+C+D, we just have to compare E > A
                // etc... thx @ybadache
                .filter(previousAndCurrentValue -> previousAndCurrentValue.get(numberOfMeasurements) > previousAndCurrentValue.get(0))
                .count();
    }

    public static void main(String[] args) {
        // part 1
        var result = Day01.calculateIncreaseNumber(1, FileUtils.getStream("input/day01.txt"));
        System.out.println("part1 result = " + result.block());

        // part 2
        result = Day01.calculateIncreaseNumber(3, FileUtils.getStream("input/day01.txt"));
        System.out.println("part2 result = " + result.block());
    }
}
