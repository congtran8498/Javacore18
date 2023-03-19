package entity;

import java.io.Serializable;

public class Buy implements Serializable {
    private Product product;
    private int quantity;
    private double price;
    private String date;

    public Buy(Product product, int quantity, double price, String date) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
