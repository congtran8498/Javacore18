import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {

        System.out.println("nhập vào số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int dem = 0;

        for (int i = 2; i < 100; i++) {

            boolean SNT = true;
            int square = (int) Math.sqrt(i);
            for (int j = 2; j <= square; j++) {
                if (i % j == 0) {
                    SNT = false;
                }
            }
            if (SNT) {
                System.out.println(i + " là SNT");
                dem += 1;
            }
            if (dem == n) {
                break;
            }
        }
    }
}
