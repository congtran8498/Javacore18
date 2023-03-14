package entity;

import java.io.Serializable;

public class StorageManagementDetail implements Serializable {
    private Product product;
    private int quantity;

    public StorageManagementDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StorageManagementDetail{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
