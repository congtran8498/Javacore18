package entity;

import java.util.Arrays;
import java.util.Scanner;

public class Tuyen implements Inputable {
    private int idTuyen;
    private double khoangCach;
    private int soDiemDung;
    private static int AUTO_ID = 100;

    public int getIdTuyen() {
        return idTuyen;
    }

    public void setIdTuyen(int idTuyen) {
        this.idTuyen = idTuyen;
    }

    public double getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(double khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    @Override
    public String toString() {
        return "Tuyen{" +
                "idTuyen=" + idTuyen +
                ", khoangCach=" + khoangCach +
                ", soDiemDung=" + soDiemDung +
                '}';
    }

    @Override
    public void inputInfo() {
        this.idTuyen = AUTO_ID;
        AUTO_ID ++;
        System.out.print("Nhập khoảng cách của tuyến (km): ");
        this.khoangCach = new Scanner(System.in).nextDouble();
        System.out.print("Nhập số điểm dừng của tuyến: ");
        this.soDiemDung = new Scanner(System.in).nextInt();
    }
}
