package logic;

import entity.Customer;
import entity.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServiceLogic {
    private Service[] services;
    private int totalService;

    public ServiceLogic(Service[] services) {
        this.services = services;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public int getTotalService() {
        return totalService;
    }

    public void setTotalService(int totalService) {
        this.totalService = totalService;
    }
    public void inputService(){
        System.out.println("Nhập số lượng loại dịch vụ: ");
        int serviceNumber;
        do {
            try {
                serviceNumber = new Scanner(System.in).nextInt();
                if(serviceNumber > 0){
                    break;
                }
                System.out.println("Nhập số dương, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai định dạng, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < serviceNumber; i++) {
            System.out.println("Nhập thông tin loại dịch vụ thứ: "+(i+1));
            Service service = new Service();
            service.inputInfo();
            saveService(service);
            System.out.println("-----------------------");
        }
        totalService +=serviceNumber;
    }

    private void saveService(Service service) {
        for (int i = 0; i < services.length; i++) {
            if(services[i] == null){
                services[i] = service;
                break;
            }
        }
    }
    public void showService(){
        for (int i = 0; i < services.length; i++) {
            if(services[i] != null){
                System.out.println(services[i]);
            }
        }
    }
    public Service searchById(int id){
        Service kq = null;
        for (int i = 0; i < services.length; i++) {
            if(services[i] != null && services[i].getServiceId() == id){
                kq = services[i];
                break;
            }
        }
        return kq;
    }
}
