package bt1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Truy xuất giá trị thông qua getter
        System.out.println("Tên: " + person.getName()); // Output: Tên: Alice
        System.out.println("Tuổi: " + person.getAge());  // Output: Tuổi: 30

        // Thay đổi giá trị thông qua setter
        person.setName("Bob");
        person.setAge(35);
        System.out.println("Tên mới: " + person.getName()); // Output: Tên mới: Bob
        System.out.println("Tuổi mới: " + person.getAge());  // Output: Tuổi mới: 35

        // Thử thiết lập tuổi không hợp lệ (ví dụ: -5)
        person.setAge(-5); // Output: Tuổi không hợp lệ!
        System.out.println("Tuổi sau khi thử thiết lập không hợp lệ: " + person.getAge()); // Output: Tuổi sau khi thử thiết lập không hợp lệ: 35 (giá trị không đổi)
    }
    //4. Lợi ích của việc sử dụng tính đóng gói trong việc bảo vệ dữ liệu và kiểm soát quyền truy cập là gì?
    //
    //Như đã đề cập ở câu hỏi 1, lợi ích chính của tính đóng gói trong việc bảo vệ dữ liệu và kiểm soát quyền truy cập bao gồm:
    //
    //Ngăn chặn truy cập trực tiếp không mong muốn: Dữ liệu private được ẩn khỏi sự truy cập trực tiếp từ bên ngoài, giảm nguy cơ bị thay đổi hoặc sử dụng sai cách.
    //
    //Kiểm soát sự thay đổi dữ liệu: Các setter cho phép bạn thêm logic kiểm tra hợp lệ dữ liệu. Ví dụ, bạn có thể đảm bảo rằng tuổi luôn là số dương, tên không được để trống, v.v. Nếu dữ liệu không hợp lệ, setter có thể từ chối thay đổi hoặc thực hiện các hành động phù hợp (ví dụ: thông báo lỗi). Điều này giúp duy trì tính toàn vẹn dữ liệu.
    //
    //Ẩn giấu chi tiết triển khai: Người dùng lớp không cần biết cách dữ liệu được lưu trữ và xử lý bên trong. Họ chỉ cần sử dụng các getter và setter. Điều này cho phép bạn thay đổi cách triển khai bên trong lớp (ví dụ: thay đổi kiểu dữ liệu của thuộc tính, cách tính toán giá trị) mà không ảnh hưởng đến mã bên ngoài, miễn là giao diện công khai (getter/setter) vẫn giữ nguyên. Điều này cải thiện tính bảo trì và linh hoạt của code.
    //
    //Tăng tính an toàn: Bằng cách kiểm soát quyền truy cập dữ liệu, tính đóng gói giúp tăng tính an toàn cho ứng dụng, đặc biệt trong các hệ thống lớn và phức tạp, nơi nhiều thành phần và người dùng có thể tương tác với dữ liệu.
    //
    //Tóm lại, tính đóng gói là một nguyên tắc thiết kế quan trọng trong OOP, giúp xây dựng các lớp có cấu trúc tốt, bảo vệ dữ liệu, kiểm soát quyền truy cập và làm cho code dễ bảo trì, tái sử dụng và an toàn hơn.
}