package entity;

import java.util.Scanner;

public class ConNguoi implements Inputable {
    protected String ten;
    protected String diaChi;
    protected String sdt;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "ConNguoi{" +
                "ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên nhân viên: ");
        this.ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ nhân viên: ");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhập sdt nhân viên: ");
        this.sdt = new Scanner(System.in).nextLine();
    }
}
