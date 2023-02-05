import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        System.out.println("nhập vào số tự nhiên: ");
        int a = new Scanner(System.in).nextInt();
        int soUoc = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.println(i + " là ước của số tự nhiên " + a);
                soUoc += 1;
            }
        }
        System.out.println("số ước của số tự nhiên " + a + " là " + soUoc);
    }
}
