package Baitap;
import java.io.*;
import java.util.*;

public class Bai6 {
    public static void main(String[] args) {
        String[] inputFiles = {"input1.txt", "input2.txt"};
        String outputFile = "output.txt";
        List<Thread> threads = new ArrayList<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String file : inputFiles) {
                Thread t = new Thread(() -> {
                    synchronized (writer) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                writer.write(line);
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                threads.add(t);
                t.start();
            }

            for (Thread t : threads) {
                t.join();
            }

            System.out.println("Ghi xong vào file tổng hợp.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}