package entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NganHang implements Inputable, Serializable {
    private int ma;
    private String ten;
    private double laiSuat;
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

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    @Override
    public String toString() {
        return "NganHang{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", laiSuat=" + laiSuat +
                '}';
    }

    @Override
    public void inputInfo() {
        this.ma = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên ngân hàng: ");
        this.ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập lãi suất: ");
        do {
            try {
                this.laiSuat = new Scanner(System.in).nextDouble();
                if (this.laiSuat > 0 && this.laiSuat <= 100) {
                    break;
                }
                System.out.println("nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
    }
}
