package entity;

import java.io.Serializable;
import java.util.Arrays;

public class SoTietKiemChiTiet2 implements Serializable {
    private SoTietKiem soTietKiems;
    private int tienGui;

    public SoTietKiemChiTiet2(SoTietKiem soTietKiems, int tienGui) {
        this.soTietKiems = soTietKiems;
        this.tienGui = tienGui;
    }

    public SoTietKiem getSoTietKiems() {
        return soTietKiems;
    }

    public void setSoTietKiems(SoTietKiem soTietKiems) {
        this.soTietKiems = soTietKiems;
    }

    public int getTienGui() {
        return tienGui;
    }

    public void setTienGui(int tienGui) {
        this.tienGui = tienGui;
    }

    @Override
    public String toString() {
        return "SoTietKiemChiTiet2{" +
                "soTietKiems=" + soTietKiems +
                ", tienGui=" + tienGui +
                '}';
    }
}
