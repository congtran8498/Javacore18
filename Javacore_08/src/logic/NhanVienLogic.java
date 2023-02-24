package logic;

import entity.NhanVien;

import java.util.Arrays;
import java.util.Scanner;

public class NhanVienLogic {
    private NhanVien[] nhanViens;
    private int totalNhanVien;

    public NhanVienLogic(NhanVien[] nhanViens) {
        this.nhanViens = nhanViens;
    }

    public NhanVien[] getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(NhanVien[] nhanViens) {
        this.nhanViens = nhanViens;
    }

    public int getTotalNhanVien() {
        return totalNhanVien;
    }

    public void setTotalNhanVien(int totalNhanVien) {
        this.totalNhanVien = totalNhanVien;
    }

    public void inputNhanVien(){
        System.out.println("Nhập số lượng nhân viên thêm vào: ");
        int nhanVienNumber;
        do {
            nhanVienNumber =new Scanner(System.in).nextInt();
            if(nhanVienNumber>0){
                break;
            }
            System.out.println("số lượng phải lớn hơn 0, hãy nhập lại: ");
        }while (true);
        for (int i = 0; i < nhanVienNumber; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ "+(i+1));
            NhanVien nhanVien = new NhanVien();
            nhanVien.inputInfo();
            saveNhanVien(nhanVien);
        }
        totalNhanVien += nhanVienNumber;
    }

    private void saveNhanVien(NhanVien nhanVien) {
        for (int i = 0; i < nhanViens.length; i++) {
            if(nhanViens[i] == null){
                nhanViens[i] = nhanVien;
                break;
            }
        }
    }
    public void showNhanVien(){
        for (int i = 0; i < nhanViens.length; i++) {
            if(nhanViens[i] != null){
                System.out.println(nhanViens[i]);
            }
        }
    }

    public NhanVien searchById(int idNhanVien) {
        NhanVien nhanVien = null;
        for (int i = 0; i < nhanViens.length; i++) {
            if(nhanViens[i] != null && nhanViens[i].getMaNhanVien() == idNhanVien){
                nhanVien = nhanViens[i];
                break;
            }
        }
        return nhanVien;
    }
}
