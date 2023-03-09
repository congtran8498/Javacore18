package logic;

import entity.BangChamCong;
import entity.CongNhan;
import entity.XuongSanXuat;
import util.FileUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuManagement {
    private CongNhanLogic congNhanLogic;
    private XuongLogic xuongLogic;
    private BangChamCongLogic bangChamCongLogic;

    public MenuManagement() {
        FileUtil<CongNhan> congNhanFileUtil = new FileUtil<>();
        List congNhanList = congNhanFileUtil.readDataFromFile("Cong-nhan.dat");
        List<CongNhan> congNhans = congNhanList == null ? new ArrayList<>() : (List<CongNhan>)congNhanList;
        congNhanLogic = new CongNhanLogic(congNhans);

        FileUtil<XuongSanXuat> xuongFileUtil = new FileUtil<>();
        List xuongList = xuongFileUtil.readDataFromFile("Xuong.dat");
        List<XuongSanXuat> xuongSanXuats = xuongList == null ? new ArrayList<>() : (List<XuongSanXuat>)xuongList;
        xuongLogic = new XuongLogic(xuongSanXuats);

        FileUtil<BangChamCong> bangChamCongFileUtil = new FileUtil<>();
        List bangChamCongList = bangChamCongFileUtil.readDataFromFile("Bang-cham-cong.dat");
        List<BangChamCong> bangChamCongs = bangChamCongList == null ? new ArrayList<>() : (List<BangChamCong>)bangChamCongList;
        bangChamCongLogic = new BangChamCongLogic(bangChamCongs, congNhanLogic,xuongLogic);
    }

    public void menu(){
        while (true){
            printMenu();
            int choice = choice();
            switch (choice){
                case 1:
                    congNhanLogic.nhapCongNhan();
                    break;
                case 2:
                    congNhanLogic.hienThiCongNhan();
                    break;
                case 3:
                    xuongLogic.nhapXuong();
                    break;
                case 4:
                    xuongLogic.hienThiXuong();
                    break;
                case 5:
                    bangChamCongLogic.lapBangChamCong();
                    break;
                case 6:
                    showShortMenu();
                    break;
                case 7:
                    bangChamCongLogic.tinhThuNhap();
                    break;
                case 8:
                    return;
            }
        }
    }
    private void showShortMenu() {
        System.out.println("Chọn chức năng mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên công nhân.");
        System.out.println("2. Sắp xếp theo xưởng.");
        int choice = 0;
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
            bangChamCongLogic.sapXepTheoTenCongNhan();
        }else {

        }
    }
    private int choice() {
        System.out.print("Mời bạn nhập lựa chọn: ");
        int temp;
        do {
            try {
                temp = new Scanner(System.in).nextInt();
                if (temp >= 1 && temp <= 8) {
                    break;
                }
                System.out.print("Nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return temp;
    }

    private void printMenu() {
        System.out.println("=========== Quản lý Công Nhân ===========");
        System.out.println("1. Nhập danh sách công nhân.");
        System.out.println("2. In danh sách công nhân.");
        System.out.println("3. Nhập danh sách xưởng.");
        System.out.println("4. In danh sách xưởng.");
        System.out.println("5. Lập bảng chấm công.");
        System.out.println("6. Sắp xếp bảng chấm công.");
        System.out.println("7. Lập bảng kê thu trong tháng.");
        System.out.println("8. Thoát.");
    }
}
