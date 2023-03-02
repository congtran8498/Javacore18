package logic;

import entity.Customer;
import entity.CustomerManagement;
import entity.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagementLogic {
    private CustomerLogic customerLogic;
    private ServiceLogic serviceLogic;
    private CustomerManagementLogic customerManagementLogic;
    public MenuManagementLogic(){
        Customer[] customers = new Customer[1000];
        customerLogic = new CustomerLogic(customers);
        Service[] services = new Service[1000];
        serviceLogic = new ServiceLogic(services);
        CustomerManagement[] customerManagements = new CustomerManagement[1000];
        customerManagementLogic = new CustomerManagementLogic(customerManagements, customerLogic, serviceLogic);
    }
    public void menu(){
        while (true){
            printMenu();
            int choice = choice();
            switch (choice){
                case 1:
                    customerLogic.inputCustomer();
                    break;
                case 2:
                    customerLogic.showCustomer();
                    break;
                case 3:
                    serviceLogic.inputService();
                    break;
                case 4:
                    serviceLogic.showService();
                    break;
                case 5:
                    customerManagementLogic.lapHoaDon();
                    break;
                case 6:
                    showShortMenu();
                    break;
                case 7:
                    customerManagementLogic.tinhThuNhap();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void showShortMenu() {
        System.out.println("Chọn chức năng mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên khách hàng.");
        System.out.println("2. Sắp xếp theo số lượng dịch vụ.");
        int choice = 0;
        System.out.println("Xin mời chọn: ");
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if(choice==1 || choice == 2) {
                    break;
                }
                System.out.println("Lựa chọn sai, vui lòng chọn lại: ");
            }catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        if(choice==1){
            customerManagementLogic.sortByCustomerName();
        }else {
            customerManagementLogic.sortByPostNumber();
        }
    }

    private int choice() {
        System.out.print("Mời bạn nhập lựa chọn: ");
        int temp;
        do {
            try {
                temp = new Scanner(System.in).nextInt();
                if (temp >= 1 && temp <= 8) {
                    break;
                }
                System.out.print("Nhập sai, hãy nhập lại: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        return temp;
    }

    private void printMenu() {
        System.out.println("=========== Quản lý dịch vụ khách hàng ===========");
        System.out.println("1. Nhập danh sách khách hàng.");
        System.out.println("2. In danh sách khách hàng.");
        System.out.println("3. Nhập danh sách kiểu dịch vụ.");
        System.out.println("4. In danh sách kiểu dịch vụ.");
        System.out.println("5. Lập hóa đơn dịch vụ.");
        System.out.println("6. Sắp xếp bảng hóa đơn.");
        System.out.println("7. Lập bảng kê tiền phải trả của khách hàng.");
        System.out.println("8. Thoát.");
    }
}
