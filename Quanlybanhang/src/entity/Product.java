package entity;

import constant.Category;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product implements Inputable, Serializable {
    private int id;
    private String name;
    private double price;
    private Category category;

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập tên sản phẩm: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        this.price = new Scanner(System.in).nextDouble();
        System.out.println("Nhập loại sản phẩm: ");
        System.out.println("1. Quần áo hè");
        System.out.println("2. Quần áo thu đông");
        System.out.println("3. Giày");
        System.out.println("4. Dép");
        System.out.println("5. Phụ kiện");
        System.out.println("Mời chọn: ");
        int choice;
        do {
            try{
                choice = new Scanner(System.in).nextInt();
                if(choice>0 && choice<=5){
                    break;
                }
                System.out.println("Nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException e){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        switch (choice){
            case 1:
                this.category = Category.QUAN_AO_HE;
                break;
            case 2:
                this.category = Category.QUAN_AO_THU_DONG;
                break;
            case 3:
                this.category = Category.GIAY;
                break;
            case 4:
                this.category = Category.DEP;
                break;
            case 5:
                this.category = Category.PHU_KIEN;
                break;
        }
    }
}
