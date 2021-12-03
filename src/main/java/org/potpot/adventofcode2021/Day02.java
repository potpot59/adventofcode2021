package org.potpot.adventofcode2021;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.potpot.adventofcode2021.util.FileUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@UtilityClass
public class Day02 {

    public static Mono<Long> calculateHorizontalPositionAndDepthPart1(Stream<String> input) {
        return Flux.fromStream(input)
                .filter(StringUtils::isNotBlank)
                .map(inputText -> inputText.split(" "))
                .collectList()
                .map(keyValueArray -> {
                    long horizontal = 0L;
                    long depth = 0L;
                    for (String[] keyValue : keyValueArray) {
                        var key = keyValue[0];
                        var value = Integer.parseInt(keyValue[1]);
                        switch (key) {
                            case "forward" -> horizontal += value;
                            case "down" -> depth += value;
                            case "up" -> depth -= value;
                        }
                    }
                    return horizontal * depth;
                });
    }

    public static Mono<Long> calculateHorizontalPositionAndDepthPart2(Stream<String> input) {
        return Flux.fromStream(input)
                .filter(StringUtils::isNotBlank)
                .map(inputText -> inputText.split(" "))
                .collectList()
                .map(keyValueArray -> {
                    long horizontal = 0L;
                    long depth = 0L;
                    long aim = 0L;
                    for (String[] keyValue : keyValueArray) {
                        var key = keyValue[0];
                        var value = Integer.parseInt(keyValue[1]);
                        switch (key) {
                            case "forward" -> {
                                horizontal += value;
                                depth += aim * value;
                            }
                            case "down" -> aim += value;
                            case "up" -> aim -= value;
                        }
                    }
                    return horizontal * depth;
                });
    }

    public static void main(String[] args) {
        // part 1
        var result = Day02.calculateHorizontalPositionAndDepthPart1(FileUtils.getStream("input/day02.txt"));
        System.out.println("part1 result = " + result.block());

        // part 2
        result = Day02.calculateHorizontalPositionAndDepthPart2(FileUtils.getStream("input/day02.txt"));
        System.out.println("part2 result = " + result.block());
    }
}
