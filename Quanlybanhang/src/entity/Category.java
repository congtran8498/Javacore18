package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Category implements Serializable {
    private String name;
    private int id;
    private String des;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", des='" + des + '\'' +
                '}';
    }
    public void inputInfo(){
        System.out.println("Nhập loại sản phẩm: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        this.des = new Scanner(System.in).nextLine();
    }
}
