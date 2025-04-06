package Baitap;
import java.io.*;
import java.util.concurrent.*;

public class Bai8 {
    public static void main(String[] args) throws Exception {
        String[] files = {"input1.txt", "input2.txt"};
        String keyword = "java";
        ExecutorService executor = Executors.newFixedThreadPool(files.length);

        for (String file : files) {
            executor.submit(() -> {
                int count = 0;
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains(keyword)) {
                            count++;
                        }
                    }
                    System.out.println("Từ khóa \"" + keyword + "\" xuất hiện " + count + " lần trong " + file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}