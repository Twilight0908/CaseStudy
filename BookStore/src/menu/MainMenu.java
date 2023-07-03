package menu;

import check.Check;

public class MainMenu {
    private Check check = new Check();
    private BookMenu bookMenu = new BookMenu();

    public void mainMenu() {
        int choice = -1;
        do {
            String str = "===== Book Store =====\n" +
                    "1. Quản Lý Cửa Hàng\n" +
                    "2. Quản Lý Khách Hàng\n" +
                    "3. Mua Sách\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    this.documentMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
            }
        } while (choice != 0);
    }

    private void documentMenu() {
        int choice = -1;
        do {
            String str = "===== Quản Lý Cửa Hàng =====\n" +
                    "1. Quản Lý Sách\n" +
                    "2. Quản Lý Truyện\n" +
                    "0. Thoát";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Nhập Lựa Chọn: ");
            choice = check.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    bookMenu.bookMenu();
                    break;
                case 2:
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
}
