package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Inputable, Serializable {
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
        return "Nguoi{" +
                "ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên công nhân: ");
        this.ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ công nhân: ");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("Nhập sdt công nhân: ");
        this.sdt = new Scanner(System.in).nextLine();
    }
}
