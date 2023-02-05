import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {

        System.out.println("nhập vào số tự nhiên a: ");
        int a = new Scanner(System.in).nextInt();
        System.out.println("nhập vào số tự nhiên b: ");
        int b = new Scanner(System.in).nextInt();

        int ucln = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                ucln = i;
            }
        }
        int bcnn = (a * b) / ucln;
        System.out.println("UCLN của 2 số " + a + " và " + b + " là :" + ucln);
        System.out.println("BCNN của 2 số " + a + " và " + b + " là :" + bcnn);
    }
}
