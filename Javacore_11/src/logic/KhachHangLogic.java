package logic;

import entity.KhachHang;
import util.File;

import java.util.InputMismatchException;
import java.util.Scanner;

public class KhachHangLogic {
    private KhachHang[] khachHangs;
    private int totalKH = 0;


    public KhachHangLogic(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public void nhapKhachHang(){
        System.out.println("Nhập số lượng khách hàng: ");
        int soLuongKhachHang;
        do {
            try {
                soLuongKhachHang = new Scanner(System.in).nextInt();
                if(soLuongKhachHang >0){
                    break;
                }
                System.out.println("nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        for (int i = 0; i < soLuongKhachHang; i++) {
            KhachHang khachHang = new KhachHang();
            khachHang.inputInfo();
            saveKhachHang(khachHang);
        }
        File.writeDataToFile(khachHangs, "khachHang.dat");
    }

    public KhachHang[] getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(KhachHang[] khachHangs) {
        this.khachHangs = khachHangs;
    }

    public int getTotalKH() {
        return totalKH;
    }

    public void setTotalKH(int totalKH) {
        this.totalKH = totalKH;
    }

    private void saveKhachHang(KhachHang khachHang) {
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] == null){
                khachHangs[i] =khachHang;
                break;
            }
        }
    }


    public void hienThiKhachHang(){
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] != null){
                System.out.println(khachHangs[i]);
            }
        }
    }

    public KhachHang searchById(int customerId) {
        KhachHang kq = null;
        for (int i = 0; i < khachHangs.length; i++) {
            if(khachHangs[i] != null && khachHangs[i].getMa() == customerId){
                kq = khachHangs[i];
                break;
            }
        }
        return kq;
    }
}
