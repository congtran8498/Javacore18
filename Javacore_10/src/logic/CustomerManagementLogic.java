package logic;

import entity.Customer;
import entity.CustomerManagement;
import entity.CustomerManagementDetail;
import entity.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManagementLogic {
    private CustomerManagement[] customerManagements;
    private CustomerLogic customerLogic;
    private ServiceLogic serviceLogic;

    public CustomerManagementLogic(CustomerManagement[] customerManagements, CustomerLogic customerLogic, ServiceLogic serviceLogic) {
        this.customerManagements = customerManagements;
        this.customerLogic = customerLogic;
        this.serviceLogic = serviceLogic;
    }

    public void lapHoaDon() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        System.out.println("Lập hóa đơn cho bao nhiêu khách hàng: ");
        int soLuongKhachHang;
        do {
            try {
                soLuongKhachHang = new Scanner(System.in).nextInt();
                if (soLuongKhachHang > 0 && soLuongKhachHang <= customerLogic.getTotalCustomer()) {
                    break;
                }
                System.out.println("Số lượng khách hàng phải là số dương và nhỏ hơn lượng khách hàng đã có: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < soLuongKhachHang; i++) {
            System.out.println("Nhập id của khách hàng thứ " + (i + 1) + " là: ");
            Customer customer = nhapKhachHang();
            System.out.println("Lập hóa đơn cho bao nhiêu dịch vụ: ");
            int soLoaiDichVu;
            do {
                try {
                    soLoaiDichVu = new Scanner(System.in).nextInt();
                    if(soLoaiDichVu > 0 && soLoaiDichVu <= serviceLogic.getTotalService() && soLoaiDichVu <=5){
                        break;
                    }
                    System.out.println("Số loại dịch vụ phải là số dương và nhỏ hơn số loai dịch vụ đã có đồng thời phải nhỏ hơn bằng 5, vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            }while (true);
            CustomerManagementDetail[] danhSachDichVu = nhapDanhSachDichVu(soLoaiDichVu);
            CustomerManagement lapHoaDon = new CustomerManagement(customer, danhSachDichVu);
            saveCustomerManagement(lapHoaDon);
        }
        showCustomerManagement();
    }

    private void showCustomerManagement() {
        for (int i = 0; i < customerManagements.length; i++) {
            if(customerManagements[i] != null){
                System.out.println(customerManagements[i]);
            }
        }
    }

    private void saveCustomerManagement(CustomerManagement lapHoaDon) {
        for (int i = 0; i < customerManagements.length; i++) {
            if(customerManagements[i] == null){
                customerManagements[i] = lapHoaDon;
                break;
            }
        }
    }

    private CustomerManagementDetail[] nhapDanhSachDichVu(int soLoaiDichVu) {
        CustomerManagementDetail[] danhSachLoaiDichVu = new CustomerManagementDetail[soLoaiDichVu];
        for (int i = 0; i < soLoaiDichVu; i++) {
            System.out.println("Nhập id cho loại dịch vụ thứ "+(i+1)+" là: ");
            int serviceId;
            Service service;
            do {
                try {
                    serviceId = new Scanner(System.in).nextInt();
                    if(serviceId <=0){
                        System.out.println("Mã dịch vụ phải dương, vui lòng nhập lại: ");
                        continue;
                    }
                    service = serviceLogic.searchById(serviceId);
                    if(service!=null){
                        break;
                    }
                    System.out.println("Không tìm thấy loại dịch vụ có mã "+(serviceId)+", vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            }while (true);
            System.out.println("Nhập số lượng sử dụng của dịch vụ: ");
            int soLuongSuDung;
            do{
                try {
                    soLuongSuDung = new Scanner(System.in).nextInt();
                    if(soLuongSuDung>0){
                        break;
                    }
                    System.out.println("Số lượng phải dương, vui lòng nhập lại: ");
                }catch (InputMismatchException ex){
                    System.out.println("Nhập sai định dạng, hãy nhập lại: ");
                }
            }while (true);
            CustomerManagementDetail detail = new CustomerManagementDetail(service, soLuongSuDung);
            saveLoaiDichVuChiTiet(detail, danhSachLoaiDichVu);
        }
        return danhSachLoaiDichVu;
    }

    private void saveLoaiDichVuChiTiet(CustomerManagementDetail detail, CustomerManagementDetail[] danhSachLoaiDichVu) {
        for (int i = 0; i < danhSachLoaiDichVu.length; i++) {
            if(danhSachLoaiDichVu[i] == null){
                danhSachLoaiDichVu[i] = detail;
                break;
            }
        }
    }

    private Customer nhapKhachHang() {
        int customerId;
        Customer customer;
        do {
            try {
                customerId = new Scanner(System.in).nextInt();
                if(customerId <= 0){
                    System.out.println("Mã khách hàng phải dương, vui lòng nhập lại: ");
                    continue;
                }
                customer = customerLogic.searchById(customerId);
                if (customer != null) {
                    break;
                }
                System.out.println("Không tìm thấy khách hàng có mã "+(customerId)+", vui lòng nhập lại: ");
            }catch (InputMismatchException ex){
                System.out.println("Nhập sai định dạng, hãy nhập lại: ");
            }
        }while (true);
        return customer;
    }
    public void sortByCustomerName() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < customerManagements.length - 1; i++) {
            for (int j = i + 1; j < customerManagements.length; j++) {
                if(customerManagements[i] != null && customerManagements[j] != null){
                    if (customerManagements[i].getCustomer().getName().trim().compareToIgnoreCase(customerManagements[j].getCustomer().getName().trim()) > 0) {
                        CustomerManagement temp = customerManagements[i];
                        customerManagements[i] = customerManagements[j];
                        customerManagements[j] = temp;
                    }
                }
            }
        }
        showCustomerManagement();
    }
    public void sortByPostNumber() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < customerManagements.length - 1; i++) {
            for (int j = i + 1; j < customerManagements.length; j++) {
                if(customerManagements[i] != null && customerManagements[j]!= null){
                    if (customerManagements[i].getTotalService() < customerManagements[j].getTotalService()) {
                        CustomerManagement temp = customerManagements[i];
                        customerManagements[i] = customerManagements[j];
                        customerManagements[j] = temp;
                    }
                }
            }
        }
        showCustomerManagement();
    }


    public void tinhThuNhap() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin khách hàng hoặc dịch vụ, vui lòng nhập danh sách khách hàng và dịch vụ trước");
            return;
        }
        for (int i = 0; i < customerManagements.length; i++) {
            double tongThuNhap = 0;
            if(customerManagements[i] != null){
                CustomerManagement baoCaoDichVu = customerManagements[i];
                CustomerManagementDetail[] danhSachDichVu = baoCaoDichVu.getCustomerManagementDetails();
                for (int j = 0; j < danhSachDichVu.length; j++) {

                    tongThuNhap += danhSachDichVu[j].getService().getPrice() * danhSachDichVu[j].getQuantity();
                }
                System.out.println("Tổng thu nhập của ông " + customerManagements[i].getCustomer().getName() + " là " + tongThuNhap);
            }
        }
    }
    private boolean coDuLieuHayChua() {
        boolean coDuLieuKhachHang = false;
        for (int i = 0; i < customerLogic.getCustomers().length; i++) {
            if (customerLogic.getCustomers()[i] != null) {
                coDuLieuKhachHang = true;
                break;
            }
        }

        boolean coDuLieuDichVu = false;
        for (int i = 0; i < serviceLogic.getServices().length; i++) {
            if (serviceLogic.getServices()[i] != null) {
                coDuLieuDichVu = true;
                break;
            }
        }

        return coDuLieuKhachHang && coDuLieuDichVu;
    }
}
