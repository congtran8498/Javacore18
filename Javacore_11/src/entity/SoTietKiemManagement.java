package entity;

import java.io.Serializable;
import java.util.Arrays;

public class SoTietKiemManagement implements Serializable {
    private KhachHang khachHang;
    private SoTietKiemChiTiet[] soTietKiemChiTiets;

    public SoTietKiemManagement(KhachHang khachHang, SoTietKiemChiTiet[] soTietKiemChiTiets) {
        this.khachHang = khachHang;
        this.soTietKiemChiTiets = soTietKiemChiTiets;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public SoTietKiemChiTiet[] getSoTietKiemChiTiets() {
        return soTietKiemChiTiets;
    }

    public void setSoTietKiemChiTiets(SoTietKiemChiTiet[] soTietKiemChiTiets) {
        this.soTietKiemChiTiets = soTietKiemChiTiets;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "khachHang=" + khachHang +
                ", soTietKiemChiTiets=" + Arrays.toString(soTietKiemChiTiets) +
                '}';
    }
}
