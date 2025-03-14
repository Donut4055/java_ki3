package bt1;

public class Person {
    //1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
    //
    //Tính đóng gói (Encapsulation) là một trong bốn nguyên tắc cơ bản của lập trình hướng đối tượng (OOP), cùng với tính kế thừa, tính đa hình và tính trừu tượng. Về cơ bản, tính đóng gói là quá trình gói gọn dữ liệu (thuộc tính) và các phương thức (hành vi) hoạt động trên dữ liệu đó vào bên trong một đơn vị duy nhất, gọi là lớp (class). Trong Java, tính đóng gói thường được thực hiện bằng cách sử dụng lớp.
    //
    //Tại sao tính đóng gói lại quan trọng?
    //
    //Tính đóng gói đóng vai trò then chốt trong lập trình hướng đối tượng vì nhiều lý do quan trọng:
    //
    //Bảo vệ dữ liệu (Data Hiding/Data Protection): Đây là lợi ích quan trọng nhất của tính đóng gói. Bằng cách đặt các thuộc tính của lớp là private (riêng tư), bạn ngăn chặn việc truy cập trực tiếp và thay đổi dữ liệu từ bên ngoài lớp. Điều này giúp bảo vệ dữ liệu khỏi sự can thiệp không mong muốn, duy trì tính toàn vẹn và nhất quán của dữ liệu. Chỉ có các phương thức được định nghĩa bên trong lớp mới có quyền truy cập và thao tác trực tiếp lên dữ liệu này.
    //
    //Kiểm soát quyền truy cập (Access Control): Tính đóng gói cho phép bạn kiểm soát cách dữ liệu được truy cập và sửa đổi thông qua các phương thức getter (lấy giá trị) và setter (thiết lập giá trị). Bạn có thể định nghĩa các quy tắc và ràng buộc trong các phương thức này để đảm bảo dữ liệu luôn ở trạng thái hợp lệ. Ví dụ: bạn có thể đặt giới hạn tuổi cho thuộc tính age thông qua phương thức setAge.
    //
    //Tính mô-đun hóa (Modularity) và Giảm sự phụ thuộc (Reduced Dependency): Tính đóng gói giúp tạo ra các lớp độc lập, hoạt động như các "hộp đen". Người dùng lớp chỉ cần quan tâm đến giao diện công khai (các phương thức public) mà không cần biết chi tiết về cách dữ liệu được lưu trữ và xử lý bên trong. Điều này làm giảm sự phụ thuộc giữa các phần khác nhau của chương trình, giúp code dễ bảo trì, sửa đổi và tái sử dụng hơn. Nếu bạn thay đổi cách triển khai bên trong lớp (ví dụ: thay đổi cách lưu trữ dữ liệu), miễn là giao diện công khai (getter/setter) vẫn giữ nguyên, các phần khác của chương trình sẽ không bị ảnh hưởng.
    //
    //Tính linh hoạt (Flexibility): Khi dữ liệu được đóng gói, bạn có thể dễ dàng thay đổi cách triển khai bên trong lớp mà không ảnh hưởng đến mã bên ngoài sử dụng lớp đó (miễn là giao diện công khai không đổi). Điều này mang lại sự linh hoạt cao trong việc phát triển và bảo trì phần mềm.
    //
    //Tính tái sử dụng (Reusability): Các lớp được đóng gói tốt có tính độc lập cao và dễ dàng được tái sử dụng trong các dự án khác nhau.
    //
    //2. Làm thế nào để áp dụng tính đóng gói trong Java? Giải thích cách sử dụng các phương thức getter và setter.
    //
    //Trong Java, tính đóng gói được áp dụng thông qua việc sử dụng các từ khóa kiểm soát truy cập (access modifiers), đặc biệt là private, và các phương thức getter/setter.

    private String name;
    private int age;

    // Constructor (để khởi tạo đối tượng)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter cho thuộc tính 'name'
    public String getName() {
        return name;
    }

    // Setter cho thuộc tính 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter cho thuộc tính 'age'
    public int getAge() {
        return age;
    }

    // Setter cho thuộc tính 'age' - có thể thêm kiểm tra hợp lệ
    public void setAge(int age) {
        if (age >= 0 && age <= 120) { // Ví dụ: Tuổi hợp lệ từ 0 đến 120
            this.age = age;
        } else {
            System.out.println("Tuổi không hợp lệ!");
        }
    }
}
