package baitap;
import java.io.*;

public class Bai2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            System.out.println("Nhập dữ liệu (gõ 'exit' để thoát):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Đã ghi dữ liệu vào file output.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}