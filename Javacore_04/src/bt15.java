import java.util.Scanner;

public class bt15 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so tu nhien: ");
        tinhTong(n);
    }

    public static int nhapSo(String thongDiep) {
        System.out.println(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static void tinhTong(int n) {
        float s = 0;
        if (n >= 1) {
            for (int i = 1; i <= n; i++) {
                s = s + (float) 1 / i;
            }
            System.out.println("tong la" + s);
        }else {
            System.out.println("n phai la so duong");
        }
    }
}
