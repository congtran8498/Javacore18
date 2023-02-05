import java.util.Scanner;

public class bt10 {
    public static void main(String[] args) {

        System.out.println("nhập vào chiều cao h: ");
        int h = new Scanner(System.in).nextInt();

        for (int i = 1; i <= 4; i++) {
            System.out.println();
            for (int j = i; j < h; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" * ");
            }
        }
    }
}
