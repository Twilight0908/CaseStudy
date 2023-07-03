package check;

import java.util.Objects;
import java.util.Scanner;

public class Check {
    private Scanner Input = new Scanner(System.in);

    public int checkInput() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Hãy Nhập Số !!!");
                System.out.print("Nhập Lựa Chọn: ");
            }
        }
        return input;
    }

    public int checkInputNumber(String str) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Hãy Nhập Số !!!");
                System.out.print(str);
            }
        }
        return input;
    }

    public String checkRegex() {
        return null;
    }
}
