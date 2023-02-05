import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        System.out.println("nhập vào chiều cao h: ");
        int h = new Scanner(System.in).nextInt();

        for (int i = 0; i < h; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
        }
    }
}
