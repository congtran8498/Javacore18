package logic;

import entity.BangChamCong;
import entity.BangChamCongChiTiet;
import entity.CongNhan;
import entity.XuongSanXuat;
import util.FileUtil;

import java.util.*;

public class BangChamCongLogic {
    private List<BangChamCong> bangChamCongs;
    private CongNhanLogic congNhanLogic;
    private XuongLogic xuongLogic;

    public BangChamCongLogic(List<BangChamCong> bangChamCongs, CongNhanLogic congNhanLogic, XuongLogic xuongLogic) {
        this.bangChamCongs = bangChamCongs;
        this.congNhanLogic = congNhanLogic;
        this.xuongLogic = xuongLogic;
    }

    public void lapBangChamCong() {
        if (xuongLogic.getXuongSanXuats().size() == 0) {
            System.out.println("vui lòng nhập danh sách xưởng");
            return;
        } else if (congNhanLogic.getCongNhans().size() == 0) {
            System.out.println("vui lòng nhập danh sách công nhân");
            return;
        }
        System.out.println("Lập bảng chấm công cho bao nhiêu công nhân: ");
        int soLuongCongNhan;
        do {
            try {
                soLuongCongNhan = new Scanner(System.in).nextInt();
                if (soLuongCongNhan > 0) {
                    break;
                }
                System.out.println("Số lượng công nhân phải là số dương và nhỏ hơn lượng công nhân đã có: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongCongNhan; i++) {
            System.out.println("Nhập mã của công nhân thứ " + (i + 1) + " là: ");
            CongNhan congNhan = nhapCongNhan();
            System.out.println("Lập bảng tính công cho bao nhiêu xưởng: ");
            int soLuongXuong;
            do {
                try {
                    soLuongXuong = new Scanner(System.in).nextInt();
                    if (soLuongXuong > 0) {
                        break;
                    }
                    System.out.println("Số lượng xưởng phải là số dương và nhỏ hơn lượng xưởng đã có: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            List<BangChamCongChiTiet> bangChamCongChiTietList = nhapDanhSachXuong(soLuongXuong);
            BangChamCong bangChamCong = new BangChamCong(congNhan, bangChamCongChiTietList);
            saveBangChamCong(bangChamCong);
        }
        FileUtil<BangChamCong> bangChamCongFileUtil = new FileUtil<>();
        bangChamCongFileUtil.writeDataToFile("Bang-cham-cong.dat", bangChamCongs);
        hienThiBangChamCong();
    }

    private void hienThiBangChamCong() {
        for (BangChamCong b : bangChamCongs) {
            System.out.println(b);
        }
    }

    private void saveBangChamCong(BangChamCong bangChamCong) {
        bangChamCongs.add(bangChamCong);
    }

    private List<BangChamCongChiTiet> nhapDanhSachXuong(int soLuongXuong) {
        List<BangChamCongChiTiet> bangChamCongChiTietList = new ArrayList<>();
        int temp = 0;
        int temp1 = 0;
        for (int i = 0; i < soLuongXuong; i++) {
            System.out.println("Nhập mã xưởng thứ " + (i + 1) + " là: ");
            int maXuong;
            XuongSanXuat xuongSanXuat;
            do {
                try {
                    maXuong = new Scanner(System.in).nextInt();
                    if (maXuong <= 0) {
                        System.out.println("Mã xưởng phải dương, vui lòng nhập lại: ");
                        continue;
                    }
                    xuongSanXuat = xuongLogic.searchById(maXuong);
                    if (xuongSanXuat != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy xưởng có mã " + (maXuong) + ", vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            System.out.println("Số lượng ngày đi làm: ");
            int soLuongNgay;
            do {
                try {
                    soLuongNgay = new Scanner(System.in).nextInt();
                    temp += soLuongNgay;
                    if (soLuongNgay > 0 && temp <= 30) {
                        temp1 = temp;
                        break;
                    }
                    temp = temp1;
                    System.out.println("Số lượng ngày phải dương và tổng số ngày nhỏ hơn = 30, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
            BangChamCongChiTiet bangChamCongChiTiet = new BangChamCongChiTiet(xuongSanXuat, soLuongNgay);
            saveDanhSachXuong(bangChamCongChiTiet, bangChamCongChiTietList);
        }
        return bangChamCongChiTietList;
    }

    private void saveDanhSachXuong(BangChamCongChiTiet bangChamCongChiTiet, List<BangChamCongChiTiet> bangChamCongChiTietList) {
        bangChamCongChiTietList.add(bangChamCongChiTiet);
    }

    private CongNhan nhapCongNhan() {
        CongNhan congNhan;
        int maCongNhan;
        do {
            try {
                maCongNhan = new Scanner(System.in).nextInt();
                if (maCongNhan <= 0) {
                    System.out.println("Mã khách hàng phải dương, vui lòng nhập lại: ");
                    continue;
                }
                congNhan = congNhanLogic.searchById(maCongNhan);
                if (congNhan != null) {
                    break;
                }
                System.out.println("Không tìm thấy công nhân có mã " + (maCongNhan) + ", vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return congNhan;
    }

    public void sapXepTheoTenCongNhan() {
        if (xuongLogic.getXuongSanXuats().size() == 0) {
            System.out.println("vui lòng nhập danh sách xưởng");
            return;
        } else if (congNhanLogic.getCongNhans().size() == 0) {
            System.out.println("vui lòng nhập danh sách công nhân");
            return;
        }
        Collections.sort(bangChamCongs, new Comparator<BangChamCong>() {
            @Override
            public int compare(BangChamCong o1, BangChamCong o2) {
                return o1.getCongNhan().getTen().compareTo(o2.getCongNhan().getTen());
            }
        });
        hienThiBangChamCong();
    }

    public void tinhThuNhap() {
        if (xuongLogic.getXuongSanXuats().size() == 0) {
            System.out.println("vui lòng nhập danh sách xưởng");
            return;
        } else if (congNhanLogic.getCongNhans().size() == 0) {
            System.out.println("vui lòng nhập danh sách công nhân");
            return;
        }
        for (int i = 0; i < bangChamCongs.size(); i++) {
            double tongThuNhap = 0;
            BangChamCong chamCong = bangChamCongs.get(i);
            List<BangChamCongChiTiet> danhSachXuong = chamCong.getBangChamCongChiTietList();
            for (int j = 0; j < danhSachXuong.size(); j++) {

                tongThuNhap += 450000 * chamCong.getCongNhan().getBac() * danhSachXuong.get(j).getXuongSanXuat().getHeSo() * danhSachXuong.get(j).getSoNgayLam()/22;
            }
            System.out.println("Tổng thu nhập của ông " + bangChamCongs.get(i).getCongNhan().getTen() + " là " + tongThuNhap);

        }
    }
}
