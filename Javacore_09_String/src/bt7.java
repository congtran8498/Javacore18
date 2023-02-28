import java.util.Arrays;
import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu kí tự: ");
        String s1 = new Scanner(System.in).nextLine();
        System.out.println("Nhập xâu tìm kiếm: ");
        String s2 = new Scanner(System.in).nextLine();
        timKiem2(s1,s2);
    }
    private static void timKiem2(String s1, String s2){
        String replace = s1.replace(s2, "");
        System.out.println(replace);
    }
}
