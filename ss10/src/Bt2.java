    //1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
    //
    //Kế thừa (Inheritance) là một trong bốn nguyên tắc cơ bản của lập trình hướng đối tượng (OOP). Nó là một cơ chế mạnh mẽ cho phép một lớp (lớp con hoặc lớp dẫn xuất - subclass or derived class) kế thừa các thuộc tính (fields) và phương thức (methods) từ một lớp khác (lớp cha hoặc lớp cơ sở - superclass or base class). Mối quan hệ giữa lớp con và lớp cha thường được gọi là mối quan hệ "is-a" (là một).
    //
    //Nó giúp ích gì trong lập trình hướng đối tượng?
    //
    //Kế thừa mang lại nhiều lợi ích to lớn trong lập trình hướng đối tượng, làm cho việc phát triển phần mềm hiệu quả và dễ bảo trì hơn:
    //
    //Tái sử dụng mã (Code Reusability): Đây là lợi ích quan trọng nhất. Thay vì phải viết lại mã tương tự ở nhiều lớp, kế thừa cho phép bạn tận dụng lại mã đã có ở lớp cha. Lớp con kế thừa tất cả các thuộc tính và phương thức không phải là private từ lớp cha. Bạn chỉ cần viết thêm mã cho các tính năng đặc trưng của lớp con, giảm đáng kể công sức lập trình và nguy cơ mắc lỗi.
    //
    //Mở rộng và tùy biến chức năng (Extensibility and Customization): Kế thừa cho phép bạn mở rộng chức năng của lớp cha mà không cần sửa đổi trực tiếp lớp cha đó. Lớp con có thể thêm các thuộc tính và phương thức mới, hoặc ghi đè (override) các phương thức của lớp cha để thay đổi hành vi cho phù hợp với nhu cầu cụ thể của lớp con. Điều này rất hữu ích khi bạn muốn tạo ra các phiên bản đặc biệt của một lớp cơ sở.
    //
    //Tính tổ chức và cấu trúc code tốt hơn (Improved Code Organization and Structure): Kế thừa giúp tạo ra một hệ thống phân cấp lớp rõ ràng, phản ánh mối quan hệ "is-a" giữa các đối tượng trong thế giới thực. Điều này làm cho code trở nên có cấu trúc hơn, dễ hiểu, dễ quản lý và dễ bảo trì. Nó cũng hỗ trợ việc mô hình hóa các hệ thống phức tạp một cách tự nhiên hơn.
    //
    //Tính đa hình (Polymorphism) - Nền tảng cho đa hình: Kế thừa là nền tảng quan trọng để triển khai tính đa hình trong OOP. Tính đa hình cho phép các đối tượng thuộc các lớp khác nhau (nhưng có chung lớp cha hoặc interface) có thể được xử lý một cách thống nhất thông qua tham chiếu đến lớp cha hoặc interface của chúng.
    //
    //2. Sự khác biệt giữa kế thừa và bao đóng (encapsulation) trong Java là gì?
    //
    //Mặc dù cả kế thừa và bao đóng đều là những nguyên tắc cơ bản của OOP, chúng phục vụ các mục đích khác nhau và có những khác biệt quan trọng:
    //Tính năng	                                      Kế thừa (Inheritance)	                                        Bao đóng (Encapsulation)
    //Mục đích chính	                            Tái sử dụng mã, mở rộng chức năng, tạo mối quan hệ "is-a"	    Bảo vệ dữ liệu, kiểm soát truy cập, ẩn giấu chi tiết bên trong
    //Mối quan hệ	                                Tạo mối quan hệ "is-a" giữa các lớp
    //                                              (lớp con là một loại lớp cha)	                                Liên quan đến việc gói gọn dữ liệu và phương thức bên trong một lớp
    //Cơ chế chính	                                Sử dụng từ khóa extends để tạo lớp con kế thừa từ lớp cha	    Sử dụng từ khóa private để ẩn dữ liệu, và public getter/setter để kiểm soát truy cập
    //Hướng tập trung	                            Quan hệ giữa các lớp (vertical - theo chiều dọc)	            Bên trong một lớp (horizontal - theo chiều ngang)
    //Tác động đến dữ liệu	                        Lớp con kế thừa cấu trúc dữ liệu và hành vi từ lớp cha	        Lớp che giấu dữ liệu và kiểm soát cách dữ liệu được truy cập và sửa đổi
    //Ví dụ	                                        Dog kế thừa từ Animal (Dog là một loại Animal)	                Lớp BankAccount bao đóng số dư tài khoản (private) và cung cấp phương thức deposit, withdraw (public)

    //3. Viết một ví dụ ngắn giải thích cách sử dụng từ khóa extends để tạo lớp con kế thừa các thuộc tính và phương thức từ lớp cha.
    // Lớp cha (Superclass) - Animal
    class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void eat() {
            System.out.println(name + " đang ăn.");
        }

        public void sleep() {
            System.out.println(name + " đang ngủ.");
        }
    }

    // Lớp con (Subclass) - Dog, kế thừa từ Animal
    class Dog extends Animal {
        String breed;

        public Dog(String name, String breed) {
            // Gọi constructor của lớp cha (Animal) để khởi tạo thuộc tính 'name'
            super(name);
            this.breed = breed;
        }

        public void bark() {
            System.out.println("Gâu gâu!");
        }

        // Ghi đè phương thức 'eat' của lớp cha (tùy chọn)
        @Override
        public void eat() {
            System.out.println(name + " đang gặm xương."); // Hành vi ăn đặc biệt của Dog
        }
    }

    public class Bt2 {
        public static void main(String[] args) {
            // Tạo đối tượng từ lớp cha (Animal)
            Animal genericAnimal = new Animal("Động vật");
            genericAnimal.eat();   // Output: Động vật đang ăn.
            genericAnimal.sleep(); // Output: Động vật đang ngủ.

            System.out.println("---");

            // Tạo đối tượng từ lớp con (Dog)
            Dog myDog = new Dog("Lucky", "Golden Retriever");
            myDog.eat();     // Output: Lucky đang gặm xương. (Phương thức 'eat' đã được ghi đè)
            myDog.sleep();   // Output: Lucky đang ngủ. (Kế thừa từ lớp Animal)
            myDog.bark();    // Output: Gâu gâu! (Phương thức riêng của lớp Dog)
            System.out.println("Tên chó: " + myDog.name); // Output: Tên chó: Lucky (Kế thừa thuộc tính 'name')
            System.out.println("Giống chó: " + myDog.breed); // Output: Giống chó: Golden Retriever (Thuộc tính riêng của lớp Dog)
        }
    }

//4. Hãy chỉ ra các lợi ích và hạn chế khi sử dụng kế thừa trong Java?
//
//Lợi ích của việc sử dụng kế thừa trong Java:
//
//Tái sử dụng mã (Code Reusability): Giảm thiểu sự trùng lặp mã, tiết kiệm thời gian và công sức phát triển.
//
//Mở rộng và tùy biến (Extensibility and Customization): Dễ dàng tạo ra các lớp mới dựa trên các lớp đã có, mở rộng và tùy biến chức năng.
//
//Tính tổ chức và cấu trúc (Organization and Structure): Tạo ra hệ thống phân cấp lớp rõ ràng, code dễ quản lý và bảo trì.
//
//Tính đa hình (Polymorphism): Nền tảng cho tính đa hình, cho phép xử lý các đối tượng thuộc các lớp khác nhau một cách thống nhất.
//
//Thời gian phát triển nhanh hơn (Faster Development Time): Tái sử dụng mã và cấu trúc tốt giúp tăng tốc quá trình phát triển phần mềm.
//
//Hạn chế của việc sử dụng kế thừa trong Java:
//
//Tính phụ thuộc cao (Tight Coupling): Kế thừa tạo ra mối quan hệ chặt chẽ giữa lớp cha và lớp con. Thay đổi ở lớp cha có thể ảnh hưởng đến tất cả các lớp con (đặc biệt nếu không cẩn thận trong thiết kế). Điều này có thể làm giảm tính linh hoạt và khả năng bảo trì nếu lạm dụng kế thừa.
//
//Vi phạm tính đóng gói (Potential Violation of Encapsulation): Mặc dù kế thừa không trực tiếp vi phạm bao đóng, việc lớp con có thể truy cập (và đôi khi sửa đổi) các thành phần protected của lớp cha có thể làm giảm mức độ kiểm soát và ẩn giấu thông tin so với bao đóng thuần túy.
//
//"Vấn đề lớp cha dễ vỡ" (Fragile Base Class Problem): Thay đổi trong lớp cha (đặc biệt là trong các phương thức mà lớp con ghi đè hoặc sử dụng) có thể vô tình làm hỏng hoặc thay đổi hành vi của các lớp con, ngay cả khi bản thân các lớp con không bị sửa đổi.
//
//Đa kế thừa không được hỗ trợ trực tiếp (No Direct Multiple Inheritance in Java): Java không cho phép một lớp kế thừa trực tiếp từ nhiều lớp cha (để tránh các vấn đề phức tạp về đa kế thừa). Tuy nhiên, Java cung cấp Interfaces như một cách để đạt được một số lợi ích của đa kế thừa.
//
//Có thể dẫn đến cấu trúc phân cấp lớp phức tạp: Nếu lạm dụng kế thừa một cách không cẩn thận, có thể tạo ra một hệ thống phân cấp lớp quá sâu và phức tạp, khó hiểu và khó quản lý.
//
//Khi nào nên sử dụng kế thừa?
//
//Khi có mối quan hệ "is-a" rõ ràng giữa các lớp (ví dụ: Dog is an Animal).
//
//Khi bạn muốn tái sử dụng mã của lớp cha và mở rộng hoặc tùy biến chức năng cho lớp con.
//
//Khi bạn muốn tạo ra một hệ thống phân cấp lớp có cấu trúc và tổ chức.
//
//Khi nào nên cân nhắc các giải pháp thay thế kế thừa (ví dụ: Composition - kết hợp)?
//
//Khi mối quan hệ giữa các lớp không phải là "is-a" mà là "has-a" hoặc "uses-a" (ví dụ: Car has an Engine, Computer uses a Keyboard). Trong trường hợp này, Composition (kết hợp) thường là một lựa chọn thiết kế tốt hơn.
//
//Khi bạn muốn giảm sự phụ thuộc giữa các lớp và tăng tính linh hoạt.
//
//Khi bạn lo ngại về các hạn chế của kế thừa, chẳng hạn như tính phụ thuộc cao hoặc vấn đề lớp cha dễ vỡ.