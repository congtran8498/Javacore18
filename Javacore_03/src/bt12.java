import java.util.Scanner;

public class bt12 {
    public static void main(String[] args) {

        System.out.println("nhập số tự nhiên lớn: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("nhập số tự nhiên bé: ");
        int m = new Scanner(System.in).nextInt();
        int dem = 0;

        for (int i = m; i <= n; i++) {
            if (i >= 0) {
                int ketQua = (int) Math.sqrt(i);
                if (ketQua * ketQua == i) {
                    dem++;
                    System.out.println(i + " là số chính phương");
                }
            }
        }
        System.out.println("tổng số chính phương từ " + m + " đến " + n + " là: " + dem);
    }
}
