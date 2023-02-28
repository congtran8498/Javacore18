import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        System.out.println("Nhập xâu kí tự: ");
        String s1 = new Scanner(System.in).nextLine();
        System.out.println("Nhập xâu cần chèn: ");
        String s2 = new Scanner(System.in).nextLine();
        System.out.println("Nhập vị trí chèn: ");
        int k = new Scanner(System.in).nextInt();
        chen(s1,s2,k);
    }

    private static void chen(String s1, String s2, int k) {
       StringBuilder sb = new StringBuilder(s1);
       sb.insert(k,s2);
       System.out.println(sb);
    }
}
