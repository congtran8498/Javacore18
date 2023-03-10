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
        System.out.println("Ch???n ch???c n??ng mong mu???n: ");
        System.out.println("1. S???p x???p theo h??? t??n c??ng nh??n.");
        System.out.println("2. S???p x???p theo x?????ng.");
        int choice = 0;
        System.out.println("Xin m???i ch???n: ");
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice==1 || choice == 2) {
                    break;
                }
                System.out.println("L???a ch???n sai, vui l??ng ch???n l???i: ");
            }catch (InputMismatchException ex) {
                System.out.println("Nh???p sai ?????nh d???ng, h??y nh???p l???i: ");
            }
        }while (true);
        if(choice==1){
            bangChamCongLogic.sapXepTheoTenCongNhan();
        }else {

        }
    }
    private int choice() {
        System.out.print("M???i b???n nh???p l???a ch???n: ");
        int temp;
        do {
            try {
                temp = new Scanner(System.in).nextInt();
                if (temp >= 1 && temp <= 8) {
                    break;
                }
                System.out.print("Nh???p sai, h??y nh???p l???i: ");
            }catch (InputMismatchException ex){
                System.out.println("Nh???p sai ?????nh d???ng, h??y nh???p l???i: ");
            }
        } while (true);
        return temp;
    }

    private void printMenu() {
        System.out.println("=========== Qu???n l?? C??ng Nh??n ===========");
        System.out.println("1. Nh???p danh s??ch c??ng nh??n.");
        System.out.println("2. In danh s??ch c??ng nh??n.");
        System.out.println("3. Nh???p danh s??ch x?????ng.");
        System.out.println("4. In danh s??ch x?????ng.");
        System.out.println("5. L???p b???ng ch???m c??ng.");
        System.out.println("6. S???p x???p b???ng ch???m c??ng.");
        System.out.println("7. L???p b???ng k?? thu trong th??ng.");
        System.out.println("8. Tho??t.");
    }
}
