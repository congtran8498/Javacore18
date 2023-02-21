package entity;

public class DriverManagementDetail {
    private Tuyen tuyen;
    private int quantity;

    public DriverManagementDetail(Tuyen tuyen, int quantity) {
        this.tuyen = tuyen;
        this.quantity = quantity;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "DriverManagementDetail{" +
                "tuyen=" + tuyen +
                ", quantity=" + quantity +
                '}';
    }
}
