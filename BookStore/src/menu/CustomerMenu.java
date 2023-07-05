package menu;

import check.Check;
import management.manager.CustomerManagement;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private CustomerManagement customerManagement = new CustomerManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void customerMenu() {
        int choice = -1;
        do {
            String str = "===== Quản Lý Khách Hàng =====\n" +
                    "1. Thêm Khách Hàng\n" +
                    "2. Sửa Khách Hàng\n" +
                    "3. Xóa Khách Hàng\n" +
                    "4. Tìm Kiếm Khách Hàng\n" +
                    "5. Hiển Thị Khách Hàng\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    editMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    findMenu();
                    break;
                case 5:
                    showAllCustomer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 0);
    }

    private void addMenu() {
        System.out.println("+++++ Thêm Khách Hàng +++++");
        String customerId;
        while (true) {
            String regex = "^kh\\d+$";
            String str = "Nhập Id Khách Hàng(vd: kh01): ";
            customerId = check.checkRegex(str, regex);
            if (customerManagement.findIndexById(customerId) == -1) {
                break;
            }
            System.out.println("Id Khách Hàng Đã Có !!!");
        }

        System.out.print("Nhập Tên Khách Hàng: ");
        String name = input.nextLine();

        System.out.print("Nhập Số Điện Thoại: ");
        String phone = input.nextLine();

        System.out.print("Nhập Địa Chỉ: ");
        String address = input.nextLine();

        Customer customer = new Customer(customerId, name, phone, address);
        customerManagement.add(customer);

        System.out.println("//////////");
    }

    private void editMenu() {
        System.out.println("!!!!! Sửa Khách Hàng !!!!!");
        String regex = "^kh\\d+$";
        String str = "Nhập Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        if (customerManagement.findIndexById(customerId) == -1) {
            System.out.println("Không Có Id Muốn Sửa");
        } else {
            System.out.print("Nhập Tên Khách Hàng: ");
            String name = input.nextLine();

            System.out.print("Nhập Số Điện Thoại: ");
            String phone = input.nextLine();

            System.out.print("Nhập Địa Chỉ: ");
            String address = input.nextLine();

            Customer customer = new Customer(customerId, name, phone, address);
            customerManagement.edit(customerId, customer);

            System.out.println("//////////");
        }
    }

    private void deleteMenu() {
        System.out.println("----- Xóa Khách Hàng -----");
        String regex = "^kh\\d+$";
        String str = "Nhập Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        customerManagement.delete(customerId);
        System.out.println("//////////");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = "%%%%% Tìm Khách Hàng %%%%%\n" +
                    "1. Tìm Khách Hàng Theo Id\n" +
                    "2. Tìm Khách Hàng Theo Tên\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    findById();
                    break;
                case 2:
                    findByName();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != 0);
    }

    private void findById() {
        System.out.println("%%%%% Tìm Khách Hàng Theo Id %%%%%");
        String regex = "^kh\\d+$";
        String str = "Nhâp Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        System.out.println("----------");
        int index = customerManagement.findIndexById(customerId);
        if (index != -1) {
            System.out.println(customerManagement.getAll().get(index).toString());
            System.out.println("//////////");
        } else {
            System.out.println("Không Tìm Thấy Khách Hàng !!!");
            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println("%%%%% Tìm Khách Hàng Theo Tên %%%%%");
        System.out.print("Nhập Tên Khách Hàng: ");
        String name = input.nextLine();
        System.out.println("----------");
        List<Customer> list = customerManagement.findByName(name);
        if (list.size() != 0) {
            for (Customer customer : list) {
                System.out.println(customer.toString());
                System.out.println("**********");
            }
        } else {
            System.out.println("Không Tìm Thấy Khách Hàng !!!");
            System.out.println("//////////");
        }
    }

    private void showAllCustomer() {
        System.out.println("***** Danh Sách Khách Hàng *****");
        for (Customer customer : customerManagement.getAll()) {
            System.out.println(customer.toString());
            System.out.println("**********");
        }
        System.out.println("//////////");
    }

}
