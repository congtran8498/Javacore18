import java.util.Arrays;
import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu kí tự: ");
        String s = new Scanner(System.in).nextLine();
        sapXep(s);
    }

    private static void sapXep(String s) {
        String[] s1 = s.trim().split("[\\s+]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length-1; i++) {
            for (int j = i+1; j < s1.length; j++) {
                if(s1[i].compareToIgnoreCase(s1[j])>0){
                    String temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
            }
        }
        for (int i = 0; i < s1.length; i++) {
            sb.append(s1[i]);
            if(i<s1.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
