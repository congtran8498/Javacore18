import java.util.Scanner;

public class bt8 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu kí tự: ");
        String s1 = new Scanner(System.in).nextLine();
        System.out.println("Nhập xâu tìm kiếm: ");
        String s2 = new Scanner(System.in).nextLine();
        timKiem(s1,s2);
    }

    private static void timKiem(String s1, String s2) {
        int i = s1.indexOf(s2);
        System.out.println(i);
    }
}
