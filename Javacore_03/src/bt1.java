import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {

        System.out.println("nhập vào số a: ");
        int a = new Scanner(System.in).nextInt();

        System.out.println("nhập vào số b: ");
        int b = new Scanner(System.in).nextInt();

        System.out.println("nhập vào số c: ");
        int c = new Scanner(System.in).nextInt();

        System.out.println("nhập vào số d: ");
        int d = new Scanner(System.in).nextInt();

        if (a >= b && a >= c && a >= d) {
            System.out.println(a + " là số lớn nhất");
        } else if (b >= a && b >= c && b >= d) {
            System.out.println(b + " là số lớn nhất");
        } else if (c >= a && c >= b && c >= d) {
            System.out.println(c + " là số lớn nhất");
        } else {
            System.out.println(d + " là số lớn nhất");
        }
    }
}