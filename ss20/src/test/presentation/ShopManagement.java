package test.presentation;



import java.util.Scanner;

import static test.business.CustomerBusiness.addCustomer;
import static test.business.CustomerBusiness.displayCustomer;
import static test.business.OrderBusiness.*;

public class ShopManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, choice1, choice2;
        do {
            System.out.println("1.quan li khach hang");
            System.out.println("2.quan li don hang");
            System.out.println("3.thoat");
            System.out.println("moi ban chon chuc nang: ");
             choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
            case 1 :
                do {
                    System.out.println("1.them khach hang");
                    System.out.println("2.hien thi khach hang");
                    System.out.println("3.quay lai");
                    System.out.println("moi ban chon chuc nang: ");
                    choice1 = sc.nextInt();
                    sc.nextLine();
                    switch (choice1) {
                        case 1:
                            addCustomer();
                            break;
                        case 2:
                            displayCustomer();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("chon sai chuc nang");
                    }
                }   while (choice1 != 3);
                break;
            case 2 :
                do {
                    System.out.println("1.them don hang");
                    System.out.println("2.hien thi don hang");
                    System.out.println("3.sua trang thai don hang");
                    System.out.println("4.don hang tre han");
                    System.out.println("5.don hang da giao");
                    System.out.println("6.tong doanh thu");
                    System.out.println("7.quay lai");
                    System.out.println("moi ban chon chuc nang: ");
                    choice2 = sc.nextInt();
                    sc.nextLine();
                    switch (choice2){
                        case 1:
                            addOrder(sc);
                            break;
                        case 2:
                            displayOrder();
                            break;
                        case 3:
                            updateStatus(sc);
                            break;
                        case 4:
                            getOrderOverdue().forEach(System.out::println);
                            break;
                        case 5:
                            getOrderDelivied().forEach(System.out::println);
                            break;
                        case 6:
//                            System.out.println(getTotalRevenue());
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("chon sai chuc nang");
                    }
                } while (choice2 != 7);
            }
        } while (choice != 3);
    }
}
