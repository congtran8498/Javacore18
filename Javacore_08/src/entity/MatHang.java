package entity;

import constant.NhomHang;

import java.util.Scanner;

public class MatHang implements Inputable {
    private int maHang;
    private String tenHang;
    private NhomHang nhomHang;
    private double gia;
    private int soLuong;
    private static int AUTO_ID = 1000;

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public NhomHang getNhomHang() {
        return nhomHang;
    }

    public void setNhomHang(NhomHang nhomHang) {
        this.nhomHang = nhomHang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "MatHang{" +
                "maHang=" + maHang +
                ", tenHang='" + tenHang + '\'' +
                ", nhomHang=" + nhomHang +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                '}';
    }

    @Override
    public void inputInfo() {
        this.maHang = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên mặt hàng: ");
        this.tenHang = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá mặt hàng: ");
        this.gia = new Scanner(System.in).nextDouble();
        System.out.println("Nhập số lượng mặt hàng: ");
        this.soLuong = new Scanner(System.in).nextInt();
        System.out.println("Nhập nhóm hàng: ");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if(choice >=1 && choice <=4){
                break;
            }
            System.out.println("Nhập sai, hãy nhập lại: ");
        }while (true);
        switch (choice){
            case 1:
                this.nhomHang = NhomHang.DIEN_TU;
                break;
            case 2:
                this.nhomHang = NhomHang.DIEN_LANH;
                break;
            case 3:
                this.nhomHang = NhomHang.MAY_TINH;
                break;
            case 4:
                this.nhomHang = NhomHang.THIET_BI_VAN_PHONG;
                break;
        }
    }
}
