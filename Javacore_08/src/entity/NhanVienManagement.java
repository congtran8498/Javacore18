package entity;

import java.util.Arrays;

public class NhanVienManagement {
    private NhanVien nhanVien;
    private NhanVienManagementDetail[] nhanVienManagementDetails;


    public NhanVienManagement(NhanVien nhanVien, NhanVienManagementDetail[] nhanVienManagementDetails) {
        this.nhanVien = nhanVien;
        this.nhanVienManagementDetails = nhanVienManagementDetails;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public NhanVienManagementDetail[] getNhanVienManagementDetails() {
        return nhanVienManagementDetails;
    }

    public void setNhanVienManagementDetails(NhanVienManagementDetail[] nhanVienManagementDetails) {
        this.nhanVienManagementDetails = nhanVienManagementDetails;
    }

    @Override
    public String toString() {
        return "NhanVienManagement{" +
                "nhanVien=" + nhanVien +
                ", nhanVienManagementDetails=" + Arrays.toString(nhanVienManagementDetails) +
                '}';
    }
}
