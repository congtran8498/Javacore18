import entity.Driver;
import entity.DriverManagement;
import entity.DriverManagementDetail;
import entity.Tuyen;

import java.util.Scanner;

public class Main {
    private static Driver[] drivers = new Driver[1000];
    private static Tuyen[] tuyens = new Tuyen[1000];
    private static DriverManagement[] driverManagements = new DriverManagement[1000];

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            printMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputDriver();
                    break;
                case 2:
                    showDriver();
                    break;
                case 3:
                    inputTuyen();
                    break;
                case 4:
                    showTuyen();
                    break;
                case 5:
                    danhSachPhanCong();
                    break;
                case 6:
                    sapXepDanhSachTheoTen();
                    break;
                case 7:
                    sapXepDanhSachTheoSoLuongTuyen();
                    break;
                case 8:
                    tinhKhoangCachChay();
                    break;
                case 9:
                    return;
            }
        }
    }

    private static void tinhKhoangCachChay() {

    }

    private static void sapXepDanhSachTheoSoLuongTuyen() {
        for (int i = 0; i < driverManagements.length - 1; i++) {
            for (int j = i + 1; j < driverManagements.length; j++) {
                if (driverManagements[j] != null && driverManagements[i] != null){
                    if (driverManagements[i].getDriverManagementDetails().length < driverManagements[j].getDriverManagementDetails().length && driverManagements[i] != null && driverManagements[j] != null) {
                        DriverManagement temp = driverManagements[i];
                        driverManagements[i] = driverManagements[j];
                        driverManagements[j] = temp;
                    }
                }
            }
        }
        showDriverManagement();
    }

    private static void sapXepDanhSachTheoTen() {
        for (int i = 0; i < driverManagements.length - 1; i++) {
            for (int j = i + 1; j < driverManagements.length; j++) {
                if (driverManagements[j] != null && driverManagements[i] != null) {
                    if (driverManagements[i].getDriver().getName().compareToIgnoreCase(driverManagements[j].getDriver().getName()) > 0) {
                        DriverManagement temp = driverManagements[i];
                        driverManagements[i] = driverManagements[j];
                        driverManagements[j] = temp;
                    }
                }
            }
        }
        showDriverManagement();
    }

    private static void danhSachPhanCong() {
        System.out.print("Số lượng tài xế muốn phân công: ");
        int driverNumber;
        do {
            driverNumber = new Scanner(System.in).nextInt();
            if (driverNumber > 0) {
                break;
            }
            System.out.print("nhập sai, hãy nhập lại: ");
        } while (true);
        int idDriver1 = 0;
        for (int i = 0; i < driverNumber; i++) {
            System.out.print("Mã số của tài xế thứ " + (i + 1) + " được phân công là: ");
            Driver driver = null;
            int idDriver;
            do {
                idDriver = new Scanner(System.in).nextInt();
                for (int j = 0; j < drivers.length; j++) {
                    if (drivers[j] != null && drivers[j].getIdDriver() == idDriver && idDriver1!=idDriver) {
                        driver = drivers[j];
                        idDriver1 = idDriver;
                        break;
                    }
                }
                if (driver != null) {
                    break;
                }
                System.out.print("Nhập sai, hãy nhập lại: ");
            } while (true);

            System.out.print("Nhập số tuyến muốn phân công cho tài xế thứ " + (i + 1) + " là: ");
            int tuyenQuantity;
            do {
                tuyenQuantity = new Scanner(System.in).nextInt();
                if (tuyenQuantity > 0) {
                    break;
                }
                System.out.print("Nhập sai, hãy nhập lại: ");
            } while (true);

            DriverManagementDetail[] phanCongTuyen = new DriverManagementDetail[tuyenQuantity];
            int count = 0;
            int tong = 0;
            int tong1 = 0;
            int tuyenId1=0;
            for (int j = 0; j < phanCongTuyen.length; j++) {
                System.out.print("Nhập mã tuyến phân công thứ " + (j + 1) + " là: ");
                Tuyen tuyen = null;
                int tuyenId;
                do {
                    tuyenId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < tuyens.length; k++) {
                        if (tuyens[k] != null && tuyens[k].getIdTuyen() == tuyenId && tuyenId1!=tuyenId) {
                            tuyen = tuyens[k];
                            tuyenId1 = tuyenId;
                            break;
                        }
                    }
                    if (tuyen != null) {
                        break;
                    }
                    System.out.print("Nhập mã sai, hãy nhập lại: ");
                } while (true);

                System.out.print("Tuyến này phân công mấy lượt: ");
                int soLuot;
                do {
                    soLuot = new Scanner(System.in).nextInt();
                    tong+=soLuot;
                    if (soLuot > 0 && tong <= 15) {
                        tong1=tong;
                        break;
                    }
                    System.out.println("Nhập sai, hãy nhập lại: ");
                    tong = tong1;
                } while (true);
                DriverManagementDetail detail = new DriverManagementDetail(tuyen, soLuot);
                phanCongTuyen[count] = detail;
                count++;
            }
            DriverManagement driverManagement = new DriverManagement(driver, phanCongTuyen);
            saveDriverManagement(driverManagement);
        }
        showDriverManagement();
    }

    private static void showDriverManagement() {
        for (int i = 0; i < driverManagements.length; i++) {
            if (driverManagements[i] != null) {
                System.out.println(driverManagements[i]);
            }
        }
    }

    private static void saveDriverManagement(DriverManagement driverManagement) {
        for (int j = 0; j < driverManagements.length; j++) {
            if (driverManagements[j] == null) {
                driverManagements[j] = driverManagement;
                break;
            }
        }
    }

    private static void showTuyen() {
        for (int i = 0; i < tuyens.length; i++) {
            if (tuyens[i] != null) {
                System.out.println(tuyens[i]);
            }
        }
    }

    private static void inputTuyen() {
        System.out.print("Nhập số lượng tuyến muốn thêm vào: ");
        int soLuongTuyen;
        do {
            soLuongTuyen = new Scanner(System.in).nextInt();
            if (soLuongTuyen > 0) {
                break;
            }
            System.out.print("Nhập sai, hãy nhập lại: ");
        } while (true);
        for (int i = 0; i < soLuongTuyen; i++) {
            Tuyen tuyen = new Tuyen();
            tuyen.inputInfo();
            saveTuyen(tuyen);
        }
    }

    private static void saveTuyen(Tuyen tuyen) {
        for (int i = 0; i < tuyens.length; i++) {
            if (tuyens[i] == null) {
                tuyens[i] = tuyen;
                break;
            }
        }
    }

    private static void showDriver() {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                System.out.println(drivers[i]);
            }
        }
    }

    private static void inputDriver() {
        System.out.print("Nhập số lượng tài xế muốn thêm vào: ");
        int driverNumber;
        do {
            driverNumber = new Scanner(System.in).nextInt();
            if (driverNumber > 0) {
                break;
            }
            System.out.print("nhập sai, hãy nhập lại: ");
        } while (true);
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            saveDriver(driver);
        }
    }

    private static void saveDriver(Driver driver) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] == null) {
                drivers[i] = driver;
                break;
            }
        }
    }

    private static int functionChoice() {
        System.out.print("Mời bạn nhập lựa chọn: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 9) {
                break;
            }
            System.out.print("nhập sai, hãy nhập lại: ");
        } while (true);
        return temp;
    }

    private static void printMenu() {
        System.out.println("============== Phần Mềm Quản Lý Lái Xe Buýt ==============");
        System.out.println("1. Nhập danh sách lái xe mới.");
        System.out.println("2. In danh sách lái xe mới.");
        System.out.println("3. Nhập danh sách tuyến xe mới.");
        System.out.println("4. In danh sách tuyến xe mới.");
        System.out.println("5. Nhập danh sách phân công cho mỗi lái xe.");
        System.out.println("6. Sắp xếp danh sách phân công theo tên lái xe.");
        System.out.println("7. Sắp xếp danh sách phân công theo số lượng tuyến giảm dần.");
        System.out.println("8. Lập bảng kê khai tổng khoảng cách chạy xe.");
        System.out.println("9. Thoát");
    }
}
