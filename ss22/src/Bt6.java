import java.io.*;

public class Bt6 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "copy.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine();
            }
            System.out.println("Đã đảo ngược và ghi vào file " + outputFileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc/ghi file: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
            System.out.println("\nNội dung của file " + outputFileName + " (đã đảo ngược):");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file copy.txt: " + e.getMessage());
        }
    }
}