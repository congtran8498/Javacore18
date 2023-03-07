package entity;

import constant.LoaiKhachHang;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KhachHang extends Nguoi implements Serializable {
    private int ma;
    private LoaiKhachHang loaiKhachHang;
    private static int AUTO_ID = 10000;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "ma=" + ma +
                ", loaiKhachHang=" + loaiKhachHang +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.ma = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập loại khách hàng: ");
        System.out.println("1. Cá nhân");
        System.out.println("2. Tập thể");
        System.out.println("3. Doanh Nghiệp");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice >=1 && choice <=3){
                    break;
                }
                System.out.println("nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        switch (choice){
            case 1:
                this.loaiKhachHang = LoaiKhachHang.CA_NHAN;
                break;
            case 2:
                this.loaiKhachHang = LoaiKhachHang.TAP_THE;
                break;
            case 3:
                this.loaiKhachHang = LoaiKhachHang.DOANH_NGHIEP;
                break;
        }
    }
}
