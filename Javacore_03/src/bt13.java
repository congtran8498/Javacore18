import java.util.Scanner;

public class bt13 {
    public static void main(String[] args) {
        System.out.println("nhập số tự nhiên : ");
        int n = new Scanner(System.in).nextInt();
        int s = 0;

        for (int i = 0; i < n; i++) {
            s += i;
            if (s % 7 == 0) {
                System.out.println("Tổng các số tự nhiên nhỏ hơn " + n + " và chia hết cho 7 là: " + s);
            }
        }
    }
}
