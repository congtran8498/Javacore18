package entity;

import java.util.Scanner;

public class NhanVien extends ConNguoi{
    private int maNhanVien;
    private String ngayKiHopDong;
    private static int AUTO_ID = 1000;

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNgayKiHopDong() {
        return ngayKiHopDong;
    }

    public void setNgayKiHopDong(String ngayKiHopDong) {
        this.ngayKiHopDong = ngayKiHopDong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien=" + maNhanVien +
                ", ngayKiHopDong='" + ngayKiHopDong + '\'' +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        this.maNhanVien = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập ngày kí hợp đồng: ");
        this.ngayKiHopDong = new Scanner(System.in).nextLine();
    }
}
