package bt1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("nhap so luong sinh vien: ");
        int n = new Scanner(System.in).nextInt();
        SinhVien[] sv = new SinhVien[n];

        for (int i = 0; i < sv.length; i++) {
            System.out.println("----------------------------------");
            sv[i] = new SinhVien();
            sv[i].nhapThongTin();
        }
        System.out.println(Arrays.toString(sv));
    }
}
