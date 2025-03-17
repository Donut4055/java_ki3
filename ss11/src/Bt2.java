public class Bt2 {
    //1. Định nghĩa và vai trò của tính trừu tượng trong Java
    //Tính trừu tượng (Abstraction) trong lập trình hướng đối tượng là quá trình ẩn giấu những chi tiết không cần thiết
    // và chỉ hiển thị những thông tin quan trọng cho người dùng. Nó giúp đơn giản hóa sự phức tạp của hệ thống bằng cách chỉ cung
    // cấp những gì cần thiết. Trong Java, tính trừu tượng giúp xây dựng phần mềm dễ bảo trì,
    // dễ mở rộng và nâng cao tính linh hoạt trong thiết kế. Đây là nền tảng quan trọng để phát triển các hệ thống lớn và phức tạp.

    //2. Phân tích:
    // Tại sao cần tính trừu tượng trong phần mềm phức tạp?
    //Tính trừu tượng giúp giảm bớt sự rối rắm trong thiết kế bằng cách phân tách phần giao diện với phần triển khai chi tiết.
    // Khi hệ thống trở nên lớn hơn, trừu tượng giúp người lập trình chỉ tập trung vào "cái gì cần làm" thay vì "làm như thế nào",
    // từ đó tăng khả năng tái sử dụng mã, bảo trì và mở rộng hệ thống dễ dàng hơn.

    //Sự khác biệt giữa lớp trừu tượng và giao diện trong Java là gì?
    //Tiêu chí	             Lớp trừu tượng (abstract class)	                        Giao diện (interface)
    //Kế thừa	             Dùng extends, chỉ kế thừa được 1 lớp	                    Dùng implements, có thể triển khai nhiều interface
    //Phương thức	         Có thể có cả phương thức trừu tượng và phương thức thường	Tất cả phương thức mặc định là trừu tượng (trước Java 8), có thể có phương thức mặc định (default) từ Java 8
    //Thuộc tính	         Có thể có biến instance (có trạng thái)	                Chỉ có hằng số (public static final)

    //Ví dụ như máy ATM: Người dùng chỉ cần biết cách sử dụng các chức năng như rút tiền, kiểm tra số dư mà không cần biết cơ chế bên
    // trong máy hoạt động như thế nào. Tương tự, điều khiển TV chỉ gồm các nút bấm, còn phần xử lý bên trong TV được trừu tượng hóa.
    // Đây chính là cách trừu tượng giúp đơn giản hóa tương tác với hệ thống phức tạp.

}
