public class Bt6 {
    public static void main(String[] args) {
        String initialString = "Hello";

        // === String ===
        System.out.println("=== String Performance ===");
        long startTime = System.nanoTime();
        String str = "Hello";
//        for (int i = 0; i < 1000000; i++) {
//            str = str + "World";
//        }
        long endTime = System.nanoTime();
        System.out.println("String: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // === StringBuilder ===
        System.out.println("\n=== StringBuilder Performance ===");
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder(initialString);
        sb.append("World".repeat(1000000));
        endTime = System.nanoTime();
        System.out.println("StringBuilder: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // === StringBuffer ===
        System.out.println("\n=== StringBuffer Performance ===");
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer(initialString);
        sbf.append("World".repeat(1000000));
        endTime = System.nanoTime();
        System.out.println("StringBuffer: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
