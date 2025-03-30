import java.io.*;


public class Bt5 {
    public static void main(String[] args) {
        String fileName = "input.txt";


        findLongestName(fileName);
    }
    private static void findLongestName(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String longestName = "";
            int maxLength = 0;

            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > maxLength) {
                    longestName = line;
                    maxLength = line.length();
                }
            }

            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên: " + maxLength);

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
