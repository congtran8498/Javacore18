import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        System.out.println("nhập vào số tự nhiên : ");
        int a = new Scanner(System.in).nextInt();
        int s = 0;

        while (a != 0) {
            s = s + a % 10;
            a = a / 10;
        }
        System.out.println("Tổng " + s);
    }
}
