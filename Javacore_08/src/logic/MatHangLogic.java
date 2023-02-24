package logic;

import entity.MatHang;
import entity.NhanVien;

import java.util.Scanner;

public class MatHangLogic {
    private MatHang[] matHangs;
    private int totalMatHang;

    public MatHangLogic(MatHang[] matHangs) {
        this.matHangs = matHangs;
    }

    public MatHang[] getMatHangs() {
        return matHangs;
    }

    public void setMatHangs(MatHang[] matHangs) {
        this.matHangs = matHangs;
    }

    public int getTotalMatHang() {
        return totalMatHang;
    }

    public void setTotalMatHang(int totalMatHang) {
        this.totalMatHang = totalMatHang;
    }
    public void inputMatHang(){
        System.out.println("Nhập số lượng mặt hàng thêm vào: ");
        int matHangNumber;
        do {
            matHangNumber =new Scanner(System.in).nextInt();
            if(matHangNumber>0){
                break;
            }
            System.out.println("số lượng phải lớn hơn 0, hãy nhập lại: ");
        }while (true);
        for (int i = 0; i < matHangNumber; i++) {
            System.out.println("Nhập thông tin cho mặt hàng thứ "+(i+1));
            MatHang matHang = new MatHang();
            matHang.inputInfo();
            saveNhanVien(matHang);
        }
        totalMatHang += matHangNumber;
    }

    private void saveNhanVien(MatHang matHang) {
        for (int i = 0; i < matHangs.length; i++) {
            if(matHangs[i] == null){
                matHangs[i] = matHang;
                break;
            }
        }
    }
    public void showMatHang(){
        for (int i = 0; i < matHangs.length; i++) {
            if(matHangs[i] != null){
                System.out.println(matHangs[i]);
            }
        }
    }

    public MatHang searchById(int idMatHang) {
        MatHang matHang = null;
        for (int i = 0; i < matHangs.length; i++) {
            if(matHangs[i] != null && matHangs[i].getMaHang() == idMatHang){
                matHang = matHangs[i];
                break;
            }
        }
        return matHang;
    }
}
