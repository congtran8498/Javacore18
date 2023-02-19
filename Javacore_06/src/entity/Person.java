package entity;

import java.util.Scanner;

public class Person {
    protected String fullName;
    protected String address;
    protected String phone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public void inputInfo(){
        System.out.print("Nhập họ tên: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.print("Nhập địa chỉ: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phone = new Scanner(System.in).nextLine();
    }
}
