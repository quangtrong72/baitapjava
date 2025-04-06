package Baitap;

import java.io.*;

public class Bai7 {
    public static void main(String[] args) throws Exception {
        File input = new File("bigfile.txt");
        long length = input.length();
        int parts = 4; // số luồng
        long partSize = length / parts;

        for (int i = 0; i < parts; i++) {
            long start = i * partSize;
            long end = (i == parts - 1) ? length : (i + 1) * partSize;
            int index = i;
            new Thread(() -> {
                try (RandomAccessFile raf = new RandomAccessFile(input, "r")) {
                    raf.seek(start);
                    byte[] buffer = new byte[(int)(end - start)];
                    raf.read(buffer);
                    synchronized (System.out) {
                        System.out.println("Phần " + index + ": " + new String(buffer));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}