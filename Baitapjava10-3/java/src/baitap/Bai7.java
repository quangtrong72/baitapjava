package baitap;
import java.io.*;
import java.util.concurrent.*;

public class Bai7 {
    private static final int THREAD_COUNT = 4;
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) throws Exception {
        File file = new File("largefile.txt");
        long fileSize = file.length();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            long start = i * CHUNK_SIZE;
            long end = Math.min(start + CHUNK_SIZE, fileSize);
            executor.execute(new FileReaderTask(file, start, end, i));
        }

        executor.shutdown();
    }

    static class FileReaderTask implements Runnable {
        private File file;
        private long start;
        private long end;
        private int id;

        public FileReaderTask(File file, long start, long end, int id) {
            this.file = file;
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public void run() {
            try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                raf.seek(start);
                byte[] buffer = new byte[(int)(end - start)];
                raf.readFully(buffer);
                System.out.println("Thread " + id + " read: " + new String(buffer));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}