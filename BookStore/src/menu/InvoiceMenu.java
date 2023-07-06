package menu;

import check.Check;
import management.manager.BookManagement;
import management.manager.ComicsManagement;
import management.manager.CustomerManagement;
import management.manager.InvoiceManagement;
import model.Invoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceMenu {
    private InvoiceManagement invoiceManagement = new InvoiceManagement();
    private BookManagement bookManagement = new BookManagement();
    private ComicsManagement comicsManagement = new ComicsManagement();
    private CustomerManagement customerManagement = new CustomerManagement();
    private Check check = new Check();

    public void invoiceMenu() {
        int choice = -1;
        do {
            String str = "===== Bán Sách =====\n" +
                    "1. Thêm Hóa Đơn\n" +
                    "2. Hiển Thị Hóa Đơn\n" +
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
                    showAllInvoice();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn !!!");
                    System.out.println("----------");
                    break;
            }
        } while (choice != -0);
    }

    private void addMenu() {
        System.out.println("+++++ Thêm Hóa Đơn +++++");
        String invoiceId;
        while (true) {
            String regex = "^iv\\d+$";
            String str = "Nhâp Id Hóa Đơn(vd: iv01): ";
            invoiceId = check.checkRegex(str, regex);
            if (invoiceManagement.findIndexById(invoiceId) == -1) {
                break;
            }
            System.out.println("Id Hóa Đơn Đã Có !!!");
        }

        String customerId;
        while (true) {
            String regex = "^kh\\d+$";
            String str = "Nhập Id Khách Hàng(vd: kh01): ";
            customerId = check.checkRegex(str, regex);
            if (customerManagement.findIndexById(customerId) != -1) {
                break;
            }
            System.out.println("Không Có Id Khách Hàng !!!");
        }

        String detail = "";
        String bookId;
        String comicsId;
        do {
            while (true) {
                String regexBook = "^b\\d+$";
                String str = "Nhập Id Sách Cần Mua(vd: b01)(Nhập b0 Để Thoát Nhập): ";
                bookId = check.checkRegex(str, regexBook);
                if (bookId.equals("b0")) {
                    break;
                } else if (bookManagement.findIndexById(bookId) != -1) {
                    break;
                }
                System.out.println("Không Có Id Sách !!!");
            }
            if (!bookId.equals("b0")) {
                detail += bookId + " ";
            }
        } while (!bookId.equals("b0"));

        do {
            while (true) {
                String regexComics = "^c\\d+$";
                String str = "Nhập Id Truyện Cần Mua(vd: c01)(Nhập c0 Để Thoát Nhập): ";
                comicsId = check.checkRegex(str, regexComics);
                if (comicsId.equals("c0")) {
                    break;
                } else if (comicsManagement.findIndexById(comicsId) != -1) {
                    break;
                }
                System.out.println("Không Có Id Truyện !!!");
            }
            if (!comicsId.equals("c0")) {
                detail += comicsId + " ";
            }
        } while (!comicsId.equals("c0"));

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        double total = 0;
        String[] data = detail.split(" ");
        for (String s : data) {
            if (s.contains("b")) {
                total += bookManagement.getAll().get(bookManagement.findIndexById(s)).getBookPrice();
            } else {
                total += comicsManagement.getAll().get(comicsManagement.findIndexById(s)).getComicsPrice();
            }
        }

        Invoice invoice = new Invoice(invoiceId, customerId, detail, formattedDate, total);
        invoiceManagement.add(invoice);

        System.out.println("//////////");
    }

    private void showAllInvoice() {
        System.out.println("***** Danh Sách Hóa Đơn *****");
        for (Invoice invoice : invoiceManagement.getAll()) {
            System.out.println(invoice.toString());
            System.out.println("**********");
        }
        System.out.println("//////////");
    }
}
