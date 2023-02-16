package bt3;

import java.util.Scanner;

public class Rectangle {
    double width;
    double height;
    String color;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void nhapThongSoHCN() {
        System.out.println("nhap chieu dai cua hcn: ");
        double w = new Scanner(System.in).nextDouble();
        System.out.println("nhap chieu rong cua hcn: ");
        double h = new Scanner(System.in).nextDouble();
        System.out.println("nhap mau sac cua hcn: ");
        String c = new Scanner(System.in).nextLine();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return width * height;
    }

    public double findPerimeter() {
        return (width + height) * 2;
    }
}
