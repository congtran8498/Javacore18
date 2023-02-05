import java.util.Scanner;

public class bt14 {
    public static void main(String[] args) {

        System.out.println("nhập số tự nhiên : ");
        int n = new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i += 2) {
            System.out.println("các số chẵn nhỏ hơn " + n + " là: " + i);
        }

        for (int i = 1; i < n; i += 2) {
            System.out.println("các số lẻ nhỏ hơn " + n + " là: " + i);
        }

    }
}
