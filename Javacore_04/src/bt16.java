import java.util.Scanner;

public class bt16 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so tu nhien: ");
        tinhTongVaChiaHetCho7(n);
    }

    public static int nhapSo(String thongDiep) {
        System.out.println(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static void tinhTongVaChiaHetCho7(int n) {
        int s = 0;
        for (int i = 0; i <= n; i++) {
            s = s + i;
            if (s % 7 == 0) {
                System.out.println("tong cac so tu nhien khong lon hon n va chia het cho 7 la: " + s);
            }
        }
    }
}
