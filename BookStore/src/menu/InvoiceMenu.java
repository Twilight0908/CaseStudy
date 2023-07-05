package menu;

import check.Check;
import management.manager.InvoiceManagement;
import model.Invoice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InvoiceMenu {
    private InvoiceManagement invoiceManagement = new InvoiceManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

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

        System.out.print("Nhập Id Khách Hàng: ");
        String customerId = input.nextLine();

        System.out.print("Nhập Id Sách/Truyện Cần Mua: ");
        String detail = input.nextLine();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        String str = "Nhập Tổng Tiền: ";
        System.out.print(str);
        double total = check.checkInputNumber(str);

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
