package Baitap;
import java.io.File;

public class Bai5 {
    public static void main(String[] args) {
        File dir = new File(".");

        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                }
            }
        } else {
            System.out.println("Không thể liệt kê file.");
        }
    }
}