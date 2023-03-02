package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Service implements Inpubable{
    private int serviceId;
    private String name;
    private double price;
    private String unit;
    private static int AUTO_ID = 100;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        this.serviceId = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên dịch vụ: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập giá của dịch vụ: ");
        do {
            try {
                this.price = new Scanner(System.in).nextDouble();
                if(this.price > 0){
                    break;
                }
                System.out.println("Nhập số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        System.out.println("Nhập đơn vị tính của dịch vụ: ");
        this.unit = new Scanner(System.in).nextLine();
    }
}
