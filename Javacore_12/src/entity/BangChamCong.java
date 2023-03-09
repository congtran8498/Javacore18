package entity;

import java.io.Serializable;
import java.util.List;

public class BangChamCong implements Serializable {
    private CongNhan congNhan;
    private List<BangChamCongChiTiet> bangChamCongChiTietList;
    private int totalDay;

    public BangChamCong(CongNhan congNhan, List<BangChamCongChiTiet> bangChamCongChiTietList) {
        this.congNhan = congNhan;
        this.bangChamCongChiTietList = bangChamCongChiTietList;
        int temp =0;
        for (int i = 0; i < bangChamCongChiTietList.size(); i++) {
            temp += bangChamCongChiTietList.get(i).getSoNgayLam();
        }
        this.totalDay = temp;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public CongNhan getCongNhan() {
        return congNhan;
    }

    public void setCongNhan(CongNhan congNhan) {
        this.congNhan = congNhan;
    }

    public List<BangChamCongChiTiet> getBangChamCongChiTietList() {
        return bangChamCongChiTietList;
    }

    public void setBangChamCongChiTietList(List<BangChamCongChiTiet> bangChamCongChiTietList) {
        this.bangChamCongChiTietList = bangChamCongChiTietList;
    }

    @Override
    public String toString() {
        return "BangChamCong{" +
                "congNhan=" + congNhan +
                ", bangChamCongChiTietList=" + bangChamCongChiTietList +
                '}';
    }
}
