import java.util.Scanner;

public class bt17 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so tu nhien: ");
        soChanVaLeNhoHon(n);
    }

    public static int nhapSo(String thongDiep) {
        System.out.println(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static void soChanVaLeNhoHon(int n) {
        for (int i = 1; i < n; i += 2) {
            System.out.println("so le nho hon n la " + i);
        }
        for (int i = 0; i < n; i += 2) {
            System.out.println("so chan nho hon n la " + i);
        }
    }
}
