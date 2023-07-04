package menu;

import check.Check;
import management.manager.ComicsManagement;
import model.Comics;

import java.util.List;
import java.util.Scanner;

public class ComicsMenu {
    private ComicsManagement comicsManagement = new ComicsManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void comicsMenu() {
        int choice = -1;
        do {
            String str = "===== Quản Lý Truyện =====\n" +
                    "1. Thêm Truyện\n" +
                    "2. Sửa Truyện\n" +
                    "3. Xóa Truyện\n" +
                    "4. Tìm Kiếm Truyện\n" +
                    "5. Hiển Thị Truyện\n" +
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
                    showAllComics();
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
        System.out.println("+++++ Thêm Truyện +++++");
        String documentId;
        while (true) {
            String regex = "^c\\d+$";
            String str = "Nhâp Id Truyện(vd: c01): ";
            documentId = check.checkRegex(str, regex);
            if (comicsManagement.findIndexById(documentId) == -1) {
                break;
            }
            System.out.println("Id Truyện Đã Có !!!");
        }

        System.out.print("Nhập Nhà Xuất Bản: ");
        String publisherName = input.nextLine();

        String str1 = "Số Lượng: ";
        System.out.print(str1);
        int releaseNumber = check.checkInputNumber(str1);

        System.out.print("Nhập Tên Truyện: ");
        String comicsName = input.nextLine();

        System.out.print("Nhập Tên Tác Giả: ");
        String authorName = input.nextLine();

        System.out.print("Nhập Thể Loại: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Trang: ";
        System.out.print(str2);
        int pageNumber = check.checkInputNumber(str2);

        String str3 = "Nhập Giá: ";
        System.out.print(str3);
        double comicsPrice = check.checkInputNumber(str3);

        Comics comics = new Comics(documentId, publisherName, releaseNumber, comicsName, authorName, category, pageNumber, comicsPrice);
        comicsManagement.add(comics);

        System.out.println("//////////");
    }

    private void editMenu() {
        System.out.println("!!!!! Sửa Truyện !!!!!");
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        if (comicsManagement.findIndexById(documentId) == -1) {
            System.out.println("Không Có Id Muốn Sửa !!!");
        } else {
            System.out.print("Nhập Nhà Xuất Bản: ");
            String publisherName = input.nextLine();

            String str1 = "Số Lượng: ";
            System.out.print(str1);
            int releaseNumber = check.checkInputNumber(str1);

            System.out.print("Nhập Tên Truyện: ");
            String comicsName = input.nextLine();

            System.out.print("Nhập Tên Tác Giả: ");
            String authorName = input.nextLine();

            System.out.print("Nhập Thể Loại: ");
            String category = input.nextLine();

            String str2 = "Nhập Số Trang: ";
            System.out.print(str2);
            int pageNumber = check.checkInputNumber(str2);

            String str3 = "Nhập Giá: ";
            System.out.print(str3);
            double comicsPrice = check.checkInputNumber(str3);

            Comics comics = new Comics(documentId, publisherName, releaseNumber, comicsName, authorName, category, pageNumber, comicsPrice);
            comicsManagement.edit(documentId, comics);
            System.out.println("//////////");
        }
    }

    private void deleteMenu() {
        System.out.println("----- Xóa Truyện -----");
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        comicsManagement.delete(documentId);
        System.out.println("//////////");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = "%%%%% Tìm Truyện %%%%%\n" +
                    "1. Tìm Truyện Theo Id\n" +
                    "2. Tìm Truyện Theo Tên\n" +
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
        System.out.println("%%%%% Tìm Truyện Theo Id %%%%%");
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        System.out.println("----------");
        int index = comicsManagement.findIndexById(documentId);
        if (index != -1) {
            System.out.println(comicsManagement.getAll().get(index).toString());
            System.out.println("//////////");
        } else {
            System.out.println("Không Tìm Thấy Truyện !!!");
            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println("%%%%% Tìm Truyện Theo Tên %%%%%");
        System.out.print("Nhập Tên Truyện: ");
        String comicsName = input.nextLine();
        System.out.println("----------");
        List<Comics> list = comicsManagement.findByName(comicsName);
        if (list.size() != 0) {
            for (Comics comics : list) {
                System.out.println(comics.toString());
                System.out.println("**********");
            }
        } else {
            System.out.println("Không Tìm Thấy Truyện !!!");
            System.out.println("//////////");
        }
    }

    private void showAllComics() {
        System.out.println("***** Danh Sách Truyện *****");
        for (Comics comics : comicsManagement.getAll()) {
            System.out.println(comics.toString());
            System.out.println("**********");
        }
        System.out.println("//////////");
    }
}
