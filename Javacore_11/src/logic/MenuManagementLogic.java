package logic;

import entity.KhachHang;
import entity.NganHang;
import entity.SoTietKiemManagement;
import util.File;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagementLogic {
    private KhachHangLogic khachHangLogic;
    private NganHangLogic nganHangLogic;
    private SoTietKiemLogic soTietKiemLogic;


    public MenuManagementLogic() {
        Object[] object1 = File.readDataFromFile("khachHang.dat");
        KhachHang[] khachHangs = object1 == null ? new KhachHang[100] : (KhachHang[]) object1;
        khachHangLogic = new KhachHangLogic(khachHangs);

        Object[] object2 = File.readDataFromFile("nganHang.dat");
        NganHang[] nganHangs = object2 == null ? new NganHang[100] : (NganHang[]) object2;
        nganHangLogic = new NganHangLogic(nganHangs);

        Object[] object3 = File.readDataFromFile("SoTietKiem.dat");
        SoTietKiemManagement[] soTietKiemManagements = object3 == null ? new SoTietKiemManagement[100] : (SoTietKiemManagement[]) object3;
        soTietKiemLogic = new SoTietKiemLogic(soTietKiemManagements, khachHangLogic, nganHangLogic);
    }

    public void menu(){
       while (true){
           printMenu();
           int choice = choice();
           switch (choice){
               case 1:
                   khachHangLogic.nhapKhachHang();
                   break;
               case 2:
                   khachHangLogic.hienThiKhachHang();
                   break;
               case 3:
                   nganHangLogic.nhapNganHang();
                   break;
               case 4:
                   nganHangLogic.hienThiNganHang();
                   break;
               case 5:
                   soTietKiemLogic.lapSoTietKiem();
                   break;
               case 6:
                   shortMenu();
                   break;
               case 7:
                   break;
               case 8:
                   return;
           }
       }
    }

    private void shortMenu() {
        System.out.println("Chọn chức năng mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên khách hàng.");
        System.out.println("2. Sắp xếp theo số tiền gửi.");
        int choice;
        System.out.println("Xin mời chọn: ");
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice==1 || choice == 2) {
                    break;
                }
                System.out.println("Lựa chọn sai, vui lòng chọn lại: ");
            }catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        if(choice==1){
            soTietKiemLogic.sortByCustomerName();
        }else {

        }
    }

    private int choice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if(choice >= 1 && choice <= 8){
                break;
            }
            System.out.println("Nhập sai, hãy nhập lại: ");
        }while (true);
        return choice;
    }

    private void printMenu() {
        System.out.println("========== QUẢN LÝ SỔ TIẾT KIỆM ==========");
        System.out.println("1. Nhập danh sách khách hàng");
        System.out.println("2. In danh sách khách hàng");
        System.out.println("3. Nhập danh sách ngân hàng");
        System.out.println("4. In danh sách ngân hàng");
        System.out.println("5. Lập sổ tiết kiệm");
        System.out.println("6. Sắp xếp danh sách sổ tiết kiệm");
        System.out.println("7. Lập bảng kê tổng tiền gửi");
        System.out.println("8. Thoát");
    }
}
