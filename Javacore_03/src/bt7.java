import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {

        System.out.println("nhập vào số kích thước chiều rộng n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("nhập vào số kích thước chiều cao m: ");
        int m = new Scanner(System.in).nextInt();

        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(" * ");
            }
        }
    }
}
