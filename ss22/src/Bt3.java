import java.io.*;

public class Bt3 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "copy.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Đã sao chép nội dung từ " + inputFileName + " sang " + outputFileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
            String line;
            System.out.println("\nNội dung của file " + outputFileName + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file copy.txt: " + e.getMessage());
        }
    }
}