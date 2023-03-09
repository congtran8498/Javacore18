package entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CongNhan extends Nguoi implements Serializable {
    private int ma;
    private int bac;
    private static int AUTO_ID=1000;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "ma=" + ma +
                ", bac=" + bac +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.ma = AUTO_ID++;
        System.out.println("Nhập bậc công nhân(1-7): ");
        do {
            try{
                this.bac = new Scanner(System.in).nextInt();
                if(this.bac>0 && this.bac<=7){
                    break;
                }
                System.out.println("Bậc công nhân là số nguyên từ 1 đến 7, vui lòng chon lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        }while (true);
    }
}
