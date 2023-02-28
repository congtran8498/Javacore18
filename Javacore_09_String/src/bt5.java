import java.util.Arrays;
import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        System.out.println("Nhập họ tên: ");
        String s = new Scanner(System.in).nextLine();
        chuyenDang(s);
    }

    private static void chuyenDang(String s) {
        String[] s1 = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append(s1[s1.length-1]).append(" ");
        for (int i = 0; i < s1.length-1; i++) {
            sb.append(s1[i]);
            if(i<s1.length-2){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
