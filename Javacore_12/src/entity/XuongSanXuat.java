package entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class XuongSanXuat implements Inputable, Serializable {
    private int ma;
    private String ten;
    private String moTa;
    private double heSo;
    private static int AUTO_ID = 100;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    @Override
    public String toString() {
        return "XuongSanXuat{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", moTa='" + moTa + '\'' +
                ", heSo=" + heSo +
                '}';
    }

    @Override
    public void inputInfo() {
        this.ma = AUTO_ID++;
        System.out.println("Nhập tên xưởng: ");
        this.ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả xưởng: ");
        this.moTa = new Scanner(System.in).nextLine();
        System.out.println("Nhập hệ số xưởng: ");
        do {
            try {
                this.heSo = new Scanner(System.in).nextDouble();
                if (this.heSo >= 1 && this.heSo <= 20) {
                    break;
                }
                System.out.println("Hệ số là số thực trong khoảng từ 1 đến 20, vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
    }
}
