package bt1;

import java.util.Scanner;

public class SinhVien {
    int maSinhvien;
    String ten;
    String lop;
    String khoa;

    public void nhapThongTin(){
        System.out.println("nhap ma sinh vien: ");
        this.maSinhvien = new Scanner(System.in).nextInt();

        System.out.println("nhap ten sinh vien: ");
        this.ten = new Scanner(System.in).nextLine();

        System.out.println("nhap lop sinh vien: ");
        this.lop = new Scanner(System.in).nextLine();

        System.out.println("nhap khoa sinh vien: ");
        this.khoa = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhvien=" + maSinhvien +
                ", ten='" + ten + '\'' +
                ", lop='" + lop + '\'' +
                ", khoa='" + khoa + '\'' +
                '}';
    }
}
