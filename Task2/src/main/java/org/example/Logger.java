package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Logger {
    public static void writer(int[] arr, String name) throws IOException {
        Path path = Paths.get(name);
        String text = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .reduce((x, y) -> x + y)
                .get();
        try {
            Files.write(path,
                    text.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл !");
        }
    }
}

