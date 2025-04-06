package baitap;

import java.io.*;
import java.util.concurrent.*;


public class Bai8 {
    private static final String KEYWORD = "java";
    private static final String[] FILES = {"file1.txt", "file2.txt", "file3.txt"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(FILES.length);

        for (String filename : FILES) {
            executor.submit(() -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    boolean found = false;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(KEYWORD)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Found in: " + filename);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}