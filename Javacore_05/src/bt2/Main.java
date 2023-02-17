package bt2;

import bt1.SinhVien;

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
        sapXepTheoTen(sv);
        sapXepTheoLop(sv);
        System.out.println(Arrays.toString(sv));
    }

    public static void sapXepTheoTen(SinhVien[] sv) {
        for (int i = 0; i < sv.length - 1; i++) {
            for (int j = i + 1; j < sv.length; j++) {
                if (sv[i].ten.compareTo(sv[j].ten) > 0) {
                    SinhVien temp = sv[i];
                    sv[i] = sv[j];
                    sv[j] = temp;
                }
            }
        }
    }

    public static void sapXepTheoLop(SinhVien[] sv) {
        for (int i = 0; i < sv.length - 1; i++) {
            for (int j = i+1; j < sv.length; j++) {
                if (sv[i].lop.compareTo(sv[j].lop) > 0) {
                    SinhVien temp = sv[i];
                    sv[i] = sv[j];
                    sv[j] = temp;
                }
            }
        }
    }
}
