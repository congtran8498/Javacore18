package logic;

import entity.KhachHang;
import entity.NganHang;
import util.File;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NganHangLogic {
    private NganHang[] nganHangs;
    private int totalNganHang=0;
    public NganHangLogic(NganHang[] nganHangs) {
        this.nganHangs = nganHangs;
    }

    public NganHang[] getNganHangs() {
        return nganHangs;
    }

    public void setNganHangs(NganHang[] nganHangs) {
        this.nganHangs = nganHangs;
    }

    public int getTotalNganHang() {
        return totalNganHang;
    }

    public void setTotalNganHang(int totalNganHang) {
        this.totalNganHang = totalNganHang;
    }

    public void nhapNganHang() {
        System.out.println("Nhập số lượng ngân hàng: ");
        int soLuongNganHang;
        do {
            try {
                soLuongNganHang = new Scanner(System.in).nextInt();
                if(soLuongNganHang >0){
                    break;
                }
                System.out.println("nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);

        for (int i = 0; i < soLuongNganHang; i++) {
            NganHang nganHang = new NganHang();
            nganHang.inputInfo();
            saveNganHang(nganHang);
        }
        File.writeDataToFile(nganHangs, "nganHang.dat");
    }

    private void saveNganHang(NganHang nganHang) {
        for (int i = 0; i < nganHangs.length; i++) {
            if(nganHangs[i] == null){
                nganHangs[i] = nganHang;
                break;
            }
        }
    }
    public void hienThiNganHang(){
        for (int i = 0; i < nganHangs.length; i++) {
            if(nganHangs[i] != null){
                System.out.println(nganHangs[i]);
            }
        }
    }

    public NganHang searchById(int nganHangId) {
        NganHang kq = null;
        for (int i = 0; i < nganHangs.length; i++) {
            if(nganHangs[i] != null && nganHangs[i].getMa() == nganHangId){
                kq = nganHangs[i];
                break;
            }
        }
        return kq;
    }
}
