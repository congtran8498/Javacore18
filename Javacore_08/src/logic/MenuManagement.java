package logic;

import entity.MatHang;
import entity.NhanVien;
import entity.NhanVienManagement;

import java.util.Scanner;

public class MenuManagement {
    private NhanVienLogic nhanVienLogic;
    private MatHangLogic matHangLogic;
    private NhanVienManagementLogic nhanVienManagementLogic;
    public MenuManagement(){
        NhanVien[] nhanViens = new NhanVien[1000];
        nhanVienLogic = new NhanVienLogic(nhanViens);
        MatHang[] matHangs = new MatHang[1000];
        matHangLogic = new MatHangLogic(matHangs);
        NhanVienManagement[] nhanVienManagements = new NhanVienManagement[1000];
        nhanVienManagementLogic = new NhanVienManagementLogic(nhanVienManagements, nhanVienLogic, matHangLogic);
    }
    public void menu() {
        while (true) {
            printMenu();
            int choice = choice();
            switch (choice) {
                case 1:
                    nhanVienLogic.inputNhanVien();
                    break;
                case 2:
                    nhanVienLogic.showNhanVien();
                    break;
                case 3:
                    matHangLogic.inputMatHang();
                    break;
                case 4:
                    matHangLogic.showMatHang();
                    break;
                case 5:
                    nhanVienManagementLogic.danhSachBanHang();
                    break;
                case 6:
                    showMenuShort();
                    break;
                case 7:
                    nhanVienManagementLogic.tinhThuNhap();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void showMenuShort() {
        System.out.println("Chọn chức năng mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên nhân viên.");
        System.out.println("2. Sắp xếp theo nhóm mặt hàng.");
        int choice = 0;
        System.out.println("Xin mời chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.println("Lựa chọn sai, vui lòng chọn lại: ");
        } while (true);
        if(choice==1){
            nhanVienManagementLogic.sapXepTheoTenNhanVien();
        }
    }

    private int choice() {
        System.out.println("Mời lựa chọn: ");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.println("Nhập sai, hãy nhập lại: ");
        } while (true);
        return choice;
    }

    private void printMenu() {
        System.out.println("=========== Quản lý bán hàng ===========");
        System.out.println("1. Nhập danh sách nhân viên");
        System.out.println("2. In danh sách nhân viên");
        System.out.println("3. Nhập danh sách mặt hàng");
        System.out.println("4. In danh sách mặt hàng");
        System.out.println("5. Lập bảng danh sách bán hàng");
        System.out.println("6. Sắp xếp danh sách bán hàng");
        System.out.println("7. Lập bảng doanh thu");
        System.out.println("8. Thoát");
    }
}

