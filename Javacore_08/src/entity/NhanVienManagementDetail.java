package entity;

public class NhanVienManagementDetail {
    private MatHang matHang;
    private int quantity;

    public NhanVienManagementDetail(MatHang matHang, int quantity) {
        this.matHang = matHang;
        this.quantity = quantity;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NhanVienManagementDetail{" +
                "matHang=" + matHang +
                ", quantity=" + quantity +
                '}';
    }
}
