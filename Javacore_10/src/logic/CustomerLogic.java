package logic;

import entity.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerLogic {
    private Customer[] customers;
    private int totalCustomer;

    public CustomerLogic(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(int totalCustomer) {
        this.totalCustomer = totalCustomer;
    }
    public void inputCustomer(){
        System.out.println("Nhập số lượng khách hàng: ");
        int customerNumber;
        do {
            try {
                customerNumber = new Scanner(System.in).nextInt();
                if(customerNumber > 0){
                    break;
                }
                System.out.println("Nhập số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < customerNumber; i++) {
            System.out.println("Nhập thông tin khách hàng thứ: "+(i+1));
            Customer customer = new Customer();
            customer.inputInfo();
            saveCustomer(customer);
            System.out.println("-----------------------");
        }
        totalCustomer +=customerNumber;
    }

    private void saveCustomer(Customer customer) {
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] == null){
                customers[i] = customer;
                break;
            }
        }
    }
    public void showCustomer(){
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null){
                System.out.println(customers[i]);
            }
        }
    }
    public Customer searchById(int id){
        Customer kq = null;
        for (int i = 0; i < customers.length; i++) {
            if(customers[i] != null && customers[i].getCustomerId() == id){
                kq = customers[i];
                break;
            }
        }
        return kq;
    }
}
