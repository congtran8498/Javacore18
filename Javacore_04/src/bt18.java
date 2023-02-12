import java.util.Scanner;

public class bt18 {
    public static void main(String[] args) {
        int m = nhapSo("nhap so: ");
        int n = nhapSo("nhap so: ");
        kiemTraSoNgto(m,n);
    }

    public static int nhapSo(String thongDiep) {
        System.out.println(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static void kiemTraSoNgto(int m, int n) {
        if (m > 0 && n > 0) {
            int so1=m;
            int so2=n;
            while (so1 != so2) {
                if (so1 > so2) {
                    so1 = so1 - so2;
                } else {
                    so2 = so2 - so1;
                }
            }
            if (so1 == 1) {
                System.out.println(m + " va " + n + " la so nguyen to cung nhau");
            }
        }

    }
}
