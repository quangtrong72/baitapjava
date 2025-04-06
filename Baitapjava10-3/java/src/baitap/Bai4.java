package baitap;
import java.io.*;

public class Bai4 {
    public static void main(String[] args) {
        String file = "numbers.dat";

        // Ghi vào file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 1; i <= 5; i++) {
                dos.writeInt(i * 10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc lại từ file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            while (true) {
                int n = dis.readInt();
                System.out.println("Số: " + n);
            }
        } catch (EOFException e) {
            System.out.println("Đọc xong danh sách.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}