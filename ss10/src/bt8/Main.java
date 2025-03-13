package bt8;

public class Main {
    public static void main(String[] args) {
        Animals[] animals = new Animals[5];
            animals[0] = new Dog("Chó", 3, "Husky");
            animals[1] = new Cat("Mèo", 2, "Đen");
            animals[2] = new Animals("Thỏ", 1);


        System.out.println("===== DANH SÁCH ĐỘNG VẬT =====");
        for (Animals a : animals) {
            if (a != null) {
                a.displayInfo();
                System.out.println("Âm thanh: " + a.makeSound());
                System.out.println("------------------------------");
            }
        }
    }
}
