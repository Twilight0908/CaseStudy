package menu;

import check.Check;
import management.manager.BookManagement;
import model.Books;

import java.util.Scanner;

public class BookMenu {
    private BookManagement bookManagement = new BookManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void bookMenu() {
        int choice = -1;
        do {
            String str = "===== Quản Lý Sách =====\n" +
                    "1. Thêm Sách\n" +
                    "2. Sửa Sách\n" +
                    "3. Xóa Sách\n" +
                    "4. Tìm Kiếm Sách\n" +
                    "5. Hiển Thị Sách\n" +
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    showAllBooks();
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
        System.out.println("+++++ Thêm Sách +++++");
        String documentId;
        while (true) {
            System.out.print("Nhâp Id Sách: ");
            documentId = input.nextLine();
            if (bookManagement.findIndexById(documentId) == -1) {
                break;
            }
            System.out.println("Id Sách Đã Có !!!");
        }

        System.out.print("Nhập Nhà Xuất Bản: ");
        String publisherName = input.nextLine();

        String str1 = "Số Lượng: ";
        System.out.print(str1);
        int releaseNumber = check.checkInputNumber(str1);

        System.out.print("Nhập Tên Sách: ");
        String bookName = input.nextLine();

        System.out.print("Nhập Tên Tác Giả: ");
        String authorName = input.nextLine();

        System.out.print("Nhập Thể Loại: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Trang: ";
        System.out.print(str2);
        int pageNumber = check.checkInputNumber(str2);

        String str3 = "Nhập Giá: ";
        System.out.print(str3);
        double bookPrice = check.checkInputNumber(str3);

        Books books = new Books(documentId, publisherName, releaseNumber, bookName, authorName, category, pageNumber, bookPrice);
        bookManagement.add(books);

        System.out.println("//////////");
    }

    private void showAllBooks() {
        System.out.println("***** Danh Sách Sách *****");
        for (Books books : bookManagement.getAll()) {
            System.out.println(books.toString());
            System.out.println("**********");
        }
        System.out.println("----------");
    }
}
