package Baitap;

import java.io.*;

public class Bai4 {
    public static void main(String[] args) {
        String file = "numbers.dat";

        // Ghi số nguyên
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 1; i <= 5; i++) {
                dos.writeInt(i * 10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc lại
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (true) {
                int number = dis.readInt();
                System.out.println("Đọc được số: " + number);
            }
        } catch (EOFException e) {
            System.out.println("Đọc xong file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}