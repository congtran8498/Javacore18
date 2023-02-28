import java.util.Arrays;
import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        String s = new Scanner(System.in).nextLine();
        chuyenDang(s);
    }

    private static void chuyenDang(String s) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                s1.append(String.valueOf(s.charAt(i)).toUpperCase());
            }else {
                s1.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }
        System.out.println(s1);
    }
}
