import java.util.*;

public class Bt8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] numStrings = input.split("\\s+");
        int[] numbers = new int[numStrings.length];
        for (int i = 0; i < numStrings.length; i++) {
            numbers[i] = Integer.parseInt(numStrings[i]);
        }

        int k = scanner.nextInt();

        Set<String> pairSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == k) {
                    int smaller = Math.min(numbers[i], numbers[j]);
                    int larger = Math.max(numbers[i], numbers[j]);
                    pairSet.add(smaller + "," + larger);
                }
            }
        }
        List<String> pairList = new ArrayList<>(pairSet);
        Collections.sort(pairList); // Sắp xếp theo thứ tự tăng dần

        if (pairList.isEmpty()) {
            System.out.println("Không tìm thấy cặp số nào!");
        } else {
            for (String pair : pairList) {
                System.out.println("[" + pair + "]");
            }
        }

        scanner.close();
    }
}