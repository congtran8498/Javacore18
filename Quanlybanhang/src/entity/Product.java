package entity;


import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product implements Inputable, Serializable {
    private int id;
    private String name;
    private double price;
    private Category category;
    private double discount;
    private Date discountFromDate;
    private Date discountToDate;
    private String from;
    private String to;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDiscountFromDate() {
        return discountFromDate;
    }

    public void setDiscountFromDate(Date discountFromDate) {
        this.discountFromDate = discountFromDate;
    }

    public Date getDiscountToDate() {
        return discountToDate;
    }

    public void setDiscountToDate(Date discountToDate) {
        this.discountToDate = discountToDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", discount=" + discount +
                ", discountFromDate=" + from +
                ", discountToDate=" + to +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên sản phẩm: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        this.price = new Scanner(System.in).nextDouble();
        System.out.println("Sản phẩm có giảm giá không: ");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice <= 2) {
                    break;
                }
                System.out.println("Lựa chọn sai, hãy chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Nhập sai định dạng, hãy chọn lại: ");
            }
        } while (true);
        if (choice == 1) {
            System.out.println("Nhập giảm giá (%): ");
            this.discount = new Scanner(System.in).nextDouble();
            do {
                try {
                    System.out.println("Ngày bắt đầu: ");
                    this.from = new Scanner(System.in).nextLine();
                    System.out.println("Ngày kết thúc:  ");
                    this.to = new Scanner(System.in).nextLine();
                    this.discountFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from);
                    this.discountToDate = new SimpleDateFormat("dd/MM/yyyy").parse(to);
                    break;
                } catch (ParseException e) {
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            } while (true);
        }
    }
}
