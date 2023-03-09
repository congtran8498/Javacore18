package entity;

import java.io.Serializable;

public class BangChamCongChiTiet implements Serializable{
    private XuongSanXuat xuongSanXuat;
    private int soNgayLam;

    public BangChamCongChiTiet(XuongSanXuat xuongSanXuat, int soNgayLam) {
        this.xuongSanXuat = xuongSanXuat;
        this.soNgayLam = soNgayLam;
    }

    public XuongSanXuat getXuongSanXuat() {
        return xuongSanXuat;
    }

    public void setXuongSanXuat(XuongSanXuat xuongSanXuat) {
        this.xuongSanXuat = xuongSanXuat;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    @Override
    public String toString() {
        return "BangChamCongChiTiet{" +
                "xuongSanXuat=" + xuongSanXuat +
                ", soNgayLam=" + soNgayLam +
                '}';
    }
}
