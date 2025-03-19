package presentation;

import java.util.Scanner;

/**
 * Interface IApp định nghĩa các hành vi chuẩn cho đối tượng ứng dụng.
 */
public interface IApp {

    // Hằng số lãi suất, mặc định là 1.1
    double INTEREST = 1.1;

    /**
     * Nhập dữ liệu cho đối tượng.
     *
     * @param scanner đối tượng Scanner dùng để nhập dữ liệu từ bàn phím.
     */
    void inputData(Scanner scanner);

    /**
     * Hiển thị dữ liệu của đối tượng.
     */
    void displayData();
}
//Lợi ích sau refactor:
//Dễ mở rộng và sử dụng lại interface trong nhiều lớp.
//Dễ bảo trì vì đã mô tả rõ ràng từng phần.
//Tuân theo coding convention tốt hơn.