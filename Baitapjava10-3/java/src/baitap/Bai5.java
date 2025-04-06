package baitap;
import java.io.File;

public class Bai5 {
    public static void main(String[] args) {
        File folder = new File(".");

        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("File: " + f.getName());
                }
            }
        } else {
            System.out.println("Không thể liệt kê file.");
        }
    }
}
