package entity;

import constant.CustomerType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Inpubable {
    private int customerId;
    private String name;
    private String address;
    private String phone;
    private CustomerType customerType;
    private static int AUTO_ID = 10000;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", customerType=" + customerType +
                '}';
    }

    @Override
    public void inputInfo() {
        this.customerId = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên khách hàng: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập sdt khách hàng: ");
        this.phone = new Scanner(System.in).nextLine();
        System.out.println("chọn loại khách hàng: ");
        System.out.println("1. Cá Nhân");
        System.out.println("2. Đại diện đơn vị hành chính");
        System.out.println("3. Đại diện đơn vị kinh doanh");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice >= 1 && choice <=3){
                    break;
                }
                System.out.println("Nhập số dương và phải nhỏ hơn bằng 3, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                this.customerType = CustomerType.CA_NHAN;
                break;
            case 2:
                this.customerType = CustomerType.DAI_DIEN_DON_VI_HANH_CHINH;
                break;
            case 3:
                this.customerType = CustomerType.DAI_DIEN_DON_VI_KINH_DOANH;
                break;
        }
    }
}
