package entity;

import java.io.Serializable;
import java.util.Arrays;

public class SoTietKiemChiTiet implements Serializable {
    private NganHang nganHangs;
    private SoTietKiemChiTiet2[] soTietKiemChiTiet2s;

    public SoTietKiemChiTiet(NganHang nganHangs, SoTietKiemChiTiet2[] soTietKiemChiTiet2s) {
        this.nganHangs = nganHangs;
        this.soTietKiemChiTiet2s = soTietKiemChiTiet2s;
    }

    public NganHang getNganHangs() {
        return nganHangs;
    }

    public void setNganHangs(NganHang nganHangs) {
        this.nganHangs = nganHangs;
    }

    public SoTietKiemChiTiet2[] getSoTietKiemChiTiet2s() {
        return soTietKiemChiTiet2s;
    }

    public void setSoTietKiemChiTiet2s(SoTietKiemChiTiet2[] soTietKiemChiTiet2s) {
        this.soTietKiemChiTiet2s = soTietKiemChiTiet2s;
    }

    @Override
    public String toString() {
        return "SoTietKiemChiTiet{" +
                "nganHangs=" + nganHangs +
                ", soTietKiemChiTiet2s=" + Arrays.toString(soTietKiemChiTiet2s) +
                '}';
    }
}
