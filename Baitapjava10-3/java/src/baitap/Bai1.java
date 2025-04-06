package baitap;

import java.io.*;

public class Bai1 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
            System.out.println("Đã sao chép dữ liệu thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}