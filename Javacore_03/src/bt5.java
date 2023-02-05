import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {

        System.out.println("nhập vào số tự nhiên : ");
        int n = new Scanner(System.in).nextInt();
        int m = n;
        int soDaoNguoc = 0;

        while (m > 0) {
            soDaoNguoc = 10 * soDaoNguoc + m % 10;
            m = m / 10;
        }

        if (soDaoNguoc == n) {
            System.out.println(n + " là số thuận nghịch");
        } else {
            System.out.println(n + " không là số thuận nghịch");
        }
    }
}
