import java.util.Scanner;

public class bt5b {
    public static void main(String[] args) {
        System.out.println("nhập chuỗi kí tự :");
        String s = new Scanner(System.in).nextLine();

        System.out.println("nhập chuỗi kí tự tìm kiếm :");
        String s1 = new Scanner(System.in).nextLine();

        System.out.println("nhập chuỗi kí tự thay thế :");
        String s2 = new Scanner(System.in).nextLine();

        String replace = s.replace(s1, s2);
        System.out.println(replace);
    }
}
