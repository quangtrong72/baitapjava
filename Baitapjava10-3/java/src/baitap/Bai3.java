package baitap;
import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Số dòng trong file là: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}