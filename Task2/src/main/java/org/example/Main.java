package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        int[] game = new int[]{1, 0, 1, 2, 2, 1, 1, 3, 1};
        String file = "C:\\Users\\first\\Desktop\\JavaCore\\Work5\\Task2\\src\\main\\resources\\game.txt";
        try {
            Logger.writer(game, file);
            printGameField(fileToArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] fileToArray(String file) throws IOException {
        try (BufferedInputStream stream = new BufferedInputStream(Files.newInputStream(Path.of(file)))) {
            String text = new String(stream.readAllBytes());
            int[] arr = new int[9];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = text.charAt(i) - '0';
            }
            return arr;
        }
    }


    public static void printGameField(int[] field) {
        char[] symbols = {' ', 'x', 'o', '.'};
        for (int i = 0; i < field.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(symbols[field[i]]);
            System.out.print(' ');
        }
    }
}