package logic;

import entity.MatHang;
import entity.NhanVien;
import entity.NhanVienManagement;
import entity.NhanVienManagementDetail;

import java.util.Scanner;

public class NhanVienManagementLogic {
    private NhanVienManagement[] nhanVienManagements;
    private NhanVienLogic nhanVienLogic;
    private MatHangLogic matHangLogic;

    public NhanVienManagementLogic(NhanVienManagement[] nhanVienManagements, NhanVienLogic nhanVienLogic, MatHangLogic matHangLogic) {
        this.nhanVienManagements = nhanVienManagements;
        this.nhanVienLogic = nhanVienLogic;
        this.matHangLogic = matHangLogic;
    }

    public void danhSachBanHang() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        System.out.println("Nhập danh sách bán hàng cho bao nhiêu nhân viên: ");
        int soLuongNhanVien;
        do {
            soLuongNhanVien = new Scanner(System.in).nextInt();
            if (soLuongNhanVien > 0 && soLuongNhanVien <= nhanVienLogic.getTotalNhanVien()) {
                break;
            }
            System.out.println("Số lượng nhân viên phải dương và nhỏ hơn số lượng nhân viên trong cửa hàng: ");
        } while (true);
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println("Nhập id nhân viên thứ " + (i + 1));
            NhanVien nhanVien = nhapNhanVien();
            System.out.println("lập danh sách cho bao nhiêu mặt hàng: ");
            int soLoaiMatHang;
            do {
                soLoaiMatHang = new Scanner(System.in).nextInt();
                if(soLoaiMatHang>=1 && soLoaiMatHang<= matHangLogic.getTotalMatHang() && soLoaiMatHang <=5){
                    break;
                }
                System.out.println("Số loại mặt hàng phải dương và nhỏ hơn số lượng mặt hàng đang có, đồng thời phải nhỏ hơn 5, vui lòng nhập lại: ");
            }while (true);
            NhanVienManagementDetail[] danhSachMatHang = nhapDanhSachMatHang(soLoaiMatHang);
            NhanVienManagement  danhSach = new NhanVienManagement(nhanVien, danhSachMatHang);
            saveNhanVienManagement(danhSach);
        }
        showNhanVienManagement();
    }
    private void showNhanVienManagement(){
        for (int i = 0; i < nhanVienManagements.length; i++) {
            if(nhanVienManagements[i] != null){
                System.out.println(nhanVienManagements[i]);
            }
        }
    }

    private void saveNhanVienManagement(NhanVienManagement danhSach) {
        for (int i = 0; i < nhanVienManagements.length; i++) {
            if(nhanVienManagements[i] == null) {
                nhanVienManagements[i] = danhSach;
                break;
            }
        }
    }

    private NhanVienManagementDetail[] nhapDanhSachMatHang(int soLoaiMatHang) {
        NhanVienManagementDetail[] danhSachMatHang = new NhanVienManagementDetail[soLoaiMatHang];
        for (int i = 0; i < soLoaiMatHang; i++) {
            System.out.println("Nhập id mặt hàng thứ "+(i+1)+" là: ");
            int idMatHang;
            MatHang matHang;
            do{
                idMatHang = new Scanner(System.in).nextInt();
                matHang = matHangLogic.searchById(idMatHang);
                if(matHang != null){
                    break;
                }
                System.out.println("Không có mặt hàng mã "+idMatHang+", vui lòng nhập lại: ");
            }while (true);
            System.out.println("Số lượng bán được của mặt hàng này: ");
            int soLuongCuaMatHang = new Scanner(System.in).nextInt();
            NhanVienManagementDetail details = new NhanVienManagementDetail(matHang,soLuongCuaMatHang);
            saveLoaiMatHangChiTiet(details, danhSachMatHang);
        }
        return danhSachMatHang;
    }

    private void saveLoaiMatHangChiTiet(NhanVienManagementDetail details, NhanVienManagementDetail[] danhSachMatHang) {
        for (int i = 0; i < danhSachMatHang.length; i++) {
            if(danhSachMatHang[i] == null){
                danhSachMatHang[i] = details;
                break;
            }
        }
    }

    private NhanVien nhapNhanVien() {
        NhanVien nhanVien;
        int idNhanVien;
        do {
            idNhanVien = new Scanner(System.in).nextInt();
            nhanVien = nhanVienLogic.searchById(idNhanVien);
            if (nhanVien != null) {
                break;
            }
            System.out.println("Không có nhân viên nào có mã "+idNhanVien+", vui lòng nhập lại: ");
        }while (true);
        return nhanVien;
    }
    public void sapXepTheoTenNhanVien(){
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin nhân viên hoặc mặt hàng, vui lòng nhập danh sách nhân viên và mặt hàng trước");
            return;
        }
        for (int i = 0; i < nhanVienManagements.length-1; i++) {
            for (int j = i+1; j < nhanVienManagements.length; j++) {
                if(nhanVienManagements[i] != null && nhanVienManagements[j] != null){
                    if(nhanVienManagements[i].getNhanVien().getTen().compareToIgnoreCase(nhanVienManagements[j].getNhanVien().getTen())>0){
                        NhanVienManagement temp = nhanVienManagements[i];
                        nhanVienManagements[i] = nhanVienManagements[j];
                        nhanVienManagements[j] = temp;
                    }
                }
            }
        }
        showNhanVienManagement();
    }
    public void tinhThuNhap() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < nhanVienManagements.length; i++) {
            double tongThuNhap = 0;
            if(nhanVienManagements[i] != null){
                NhanVienManagement baoCaoBaiViet = nhanVienManagements[i];
                NhanVienManagementDetail[] danhSachBaiViet = baoCaoBaiViet.getNhanVienManagementDetails();
                for (int j = 0; j < danhSachBaiViet.length; j++) {

                    tongThuNhap += danhSachBaiViet[j].getMatHang().getGia() * danhSachBaiViet[j].getQuantity();
                }
                System.out.println("Tổng thu nhập của ông " + nhanVienManagements[i].getNhanVien().getTen() + " là " + tongThuNhap);
            }
        }
    }

    private boolean coDuLieuHayChua() {
        boolean coDuLieuNhanVien = false;
        for (int i = 0; i < nhanVienLogic.getNhanViens().length; i++) {
            if (nhanVienLogic.getNhanViens()[i] != null) {
                coDuLieuNhanVien = true;
                break;
            }
        }

        boolean coDuLieuMatHang = false;
        for (int i = 0; i < matHangLogic.getMatHangs().length; i++) {
            if (matHangLogic.getMatHangs() != null) {
                coDuLieuMatHang = true;
                break;
            }
        }

        return coDuLieuNhanVien && coDuLieuMatHang;
    }
}
