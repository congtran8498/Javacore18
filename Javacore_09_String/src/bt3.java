import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bt3 {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        String s = new Scanner(System.in).nextLine();
        chuyenDang(s);
    }

    private static void chuyenDang(String s) {
        String[] s1 = s.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            sb.append(String.valueOf(s1[i].charAt(0)).toUpperCase()).append(s1[i].substring(1));
            if (i < s1.length - 1) {
               sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
