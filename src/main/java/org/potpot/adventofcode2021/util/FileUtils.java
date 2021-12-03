package org.potpot.adventofcode2021.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@UtilityClass
public class FileUtils {

    @SneakyThrows
    public Stream<String> getStream(String filePath) {
        return Files.lines(Path.of(filePath));
    }
}
