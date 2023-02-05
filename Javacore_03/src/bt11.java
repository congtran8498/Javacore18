import java.util.Scanner;

public class bt11 {
    public static void main(String[] args) {

        System.out.println("nhập số tự nhiên : ");
        int n = new Scanner(System.in).nextInt();

        int s = 0;
        int s1 = 0;
        int s2 = 0;

        for (int i = 0; i < n; i++) {
            s += i;
        }
        System.out.println("Tổng các số tự nhiên không lớn hơn n là: " + s);

        for (int i = 1; i < n; i += 2) {
            s1 += i;
        }
        System.out.println("Tổng các số tự nhiên lẻ không lớn hơn n là: " + s1);

        for (int i = 0; i < n; i += 2) {
            s2 += i;
        }
        System.out.println("Tổng các số tự nhiên chẵn không lớn hơn n là: " + s2);


    }
}
