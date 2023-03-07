package logic;

import entity.*;
import util.File;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SoTietKiemLogic {
    private SoTietKiemManagement[] soTietKiemManagements;
    private KhachHangLogic khachHangLogic;
    private NganHangLogic nganHangLogic;
    private SoTietKiemChiTiet2[] soTietKiemChiTiet2s;


    public SoTietKiemLogic(SoTietKiemManagement[] soTietKiemManagements, KhachHangLogic khachHangLogic, NganHangLogic nganHangLogic) {
        this.soTietKiemManagements = soTietKiemManagements;
        this.khachHangLogic = khachHangLogic;
        this.nganHangLogic = nganHangLogic;
    }

    public void lapSoTietKiem() {
        System.out.println("Lập sổ tiết kiệm cho bao nhiêu khách hàng: ");
        int soLuongKhachHang;
        do {
            try {
                soLuongKhachHang = new Scanner(System.in).nextInt();
                if (soLuongKhachHang > 0) {
                    break;
                }
                System.out.println("Số lượng khách hàng phải là số dương và nhỏ hơn lượng khách hàng đã có: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongKhachHang; i++) {
            System.out.println("Nhập id của khách hàng thứ " + (i + 1) + " là: ");
            KhachHang khachHang = nhapKhachHang();
            System.out.println("Lập sổ tiết kiệm cho bao nhiêu ngân hàng: ");
            int soLoaiNganHang;
            do {
                try {
                    soLoaiNganHang = new Scanner(System.in).nextInt();
                    if (soLoaiNganHang > 0 ) {
                        break;
                    }
                    System.out.println("Số loại ngân hàng phải là số dương và nhỏ hơn số loai ngân hàng đã có, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            SoTietKiemChiTiet[] danhSachNganHang = nhapDanhSachNganHang(soLoaiNganHang);
            SoTietKiemManagement lapSo = new SoTietKiemManagement(khachHang, danhSachNganHang);
            saveLapSo(lapSo);
        }
        File.writeDataToFile(soTietKiemManagements, "SoTietKiem.dat");
        showSoTietKiem();
    }

    private void showSoTietKiem() {
        for (int i = 0; i < soTietKiemManagements.length; i++) {
            if (soTietKiemManagements[i] != null) {
                System.out.println(soTietKiemManagements[i]);
            }
        }
    }

    private void saveLapSo(SoTietKiemManagement lapSo) {
        for (int i = 0; i < soTietKiemManagements.length; i++) {
            if (soTietKiemManagements[i] == null) {
                soTietKiemManagements[i] = lapSo;
                break;
            }
        }
    }

    private SoTietKiemChiTiet[] nhapDanhSachNganHang(int soLoaiNganHang) {
        SoTietKiemChiTiet[] danhSachNganHang = new SoTietKiemChiTiet[soLoaiNganHang];
        for (int i = 0; i < soLoaiNganHang; i++) {
            System.out.println("Nhập id cho loại ngân hàng thứ " + (i + 1) + " là: ");
            int NganHangId;
            NganHang nganHang;
            do {
                try {
                    NganHangId = new Scanner(System.in).nextInt();
                    if (NganHangId <= 0) {
                        System.out.println("Mã ngân hàng phải dương, vui lòng nhập lại: ");
                        continue;
                    }
                    nganHang = nganHangLogic.searchById(NganHangId);
                    if (nganHang != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy loại ngân hàng có mã " + (NganHangId) + ", vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            System.out.println("Nhập số lượng sổ tiết kiệm: ");
            int soLuongSo;
            do {
                try {
                    soLuongSo = new Scanner(System.in).nextInt();
                    if (soLuongSo > 0 && soLuongSo <= 5) {
                        break;
                    }
                    System.out.println("Số lượng phải dương và nhỏ hơn bằng 5, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            soTietKiemChiTiet2s = new SoTietKiemChiTiet2[soLuongSo];
            for (int j = 0; j < soLuongSo; j++) {
                SoTietKiem soTietKiem = new SoTietKiem();
                soTietKiem.nhapSo();
                System.out.println("Nhập số tiền gửi cho sổ thứ "+(j+1)+" là: ");
                int soTienGui;
                do {
                    try {
                        soTienGui = new Scanner(System.in).nextInt();
                        if (soTienGui > 0) {
                            break;
                        }
                        System.out.println("Số tiền phải dương, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                    }
                } while (true);
                SoTietKiemChiTiet2 chiTiet2 = new SoTietKiemChiTiet2(soTietKiem, soTienGui);
                saveSoTietKiemChiTiet2(chiTiet2);
            }
            SoTietKiemChiTiet chiTiet = new SoTietKiemChiTiet(nganHang, soTietKiemChiTiet2s);
            saveSoTietKiemChiTiet(chiTiet, danhSachNganHang);
        }
        return danhSachNganHang;
    }

    private void saveSoTietKiemChiTiet2(SoTietKiemChiTiet2 chiTiet2) {
        for (int i = 0; i < soTietKiemChiTiet2s.length; i++) {
            if(soTietKiemChiTiet2s[i]==null){
                soTietKiemChiTiet2s[i] = chiTiet2;
                break;
            }
        }
    }

    private KhachHang nhapKhachHang () {
            KhachHang khachHang;
            int customerId;
            do {
                try {
                    customerId = new Scanner(System.in).nextInt();
                    if (customerId <= 0) {
                        System.out.println("Mã khách hàng phải dương, vui lòng nhập lại: ");
                        continue;
                    }
                    khachHang = khachHangLogic.searchById(customerId);
                    if (khachHang != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy khách hàng có mã " + (customerId) + ", vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            return khachHang;
        }

        private void saveSoTietKiemChiTiet (SoTietKiemChiTiet chiTiet, SoTietKiemChiTiet[]danhSachNganHang){
            for (int i = 0; i < danhSachNganHang.length; i++) {
                if (danhSachNganHang[i] == null) {
                    danhSachNganHang[i] = chiTiet;
                    break;
                }
            }
        }
        public void sortByCustomerName () {
            if (!coDuLieuHayChua()) {
                System.out.println("Chưa có thông tin khách hàng hoặc ngân hàng, vui lòng nhập danh sách khách hàng và ngân hàng trước");
                return;
            }
            for (int i = 0; i < soTietKiemManagements.length - 1; i++) {
                for (int j = i + 1; j < soTietKiemManagements.length; j++) {
                    if (soTietKiemManagements[i] != null && soTietKiemManagements[j] != null) {
                        if (soTietKiemManagements[i].getKhachHang().getTen().trim().compareToIgnoreCase(soTietKiemManagements[j].getKhachHang().getTen().trim()) > 0) {
                            SoTietKiemManagement temp = soTietKiemManagements[i];
                            soTietKiemManagements[i] = soTietKiemManagements[j];
                            soTietKiemManagements[j] = temp;
                        }
                    }
                }
            }
            showSoTietKiem();
        }

        private boolean coDuLieuHayChua () {
            boolean coDuLieuKhachHang = false;
            for (int i = 0; i < khachHangLogic.getKhachHangs().length; i++) {
                if (khachHangLogic.getKhachHangs()[i] != null) {
                    coDuLieuKhachHang = true;
                    break;
                }
            }

            boolean coDuLieuNganHang = false;
            for (int i = 0; i < nganHangLogic.getNganHangs().length; i++) {
                if (nganHangLogic.getNganHangs()[i] != null) {
                    coDuLieuNganHang = true;
                    break;
                }
            }

            return coDuLieuKhachHang && coDuLieuNganHang;
        }
    }
