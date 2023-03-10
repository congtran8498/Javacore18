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
                if (driverManagements[j] != null && driverManagements[i] != null) {
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
        System.out.print("S??? l?????ng t??i x??? mu???n ph??n c??ng: ");
        int driverNumber = validate();

        int idDriver1 = 0;
        for (int i = 0; i < driverNumber; i++) {
            System.out.print("M?? s??? c???a t??i x??? th??? " + (i + 1) + " ???????c ph??n c??ng l??: ");
            Driver driver = null;
            int idDriver;
            do {
                idDriver = new Scanner(System.in).nextInt();
                for (int j = 0; j < drivers.length; j++) {
                    if (drivers[j] != null && drivers[j].getIdDriver() == idDriver && idDriver1 != idDriver) {
                        driver = drivers[j];
                        idDriver1 = idDriver;
                        break;
                    }
                }
                if (driver != null) {
                    break;
                }
                System.out.print("Nh???p sai, h??y nh???p l???i: ");
            } while (true);

            System.out.print("Nh???p s??? tuy???n mu???n ph??n c??ng cho t??i x??? th??? " + (i + 1) + " l??: ");
            int tuyenQuantity = validate();

            DriverManagementDetail[] phanCongTuyen = new DriverManagementDetail[tuyenQuantity];
            int count = 0;
            int tong = 0;
            int tong1 = 0;
            int tuyenId1 = 0;
            for (int j = 0; j < phanCongTuyen.length; j++) {
                System.out.print("Nh???p m?? tuy???n ph??n c??ng th??? " + (j + 1) + " l??: ");
                Tuyen tuyen = null;
                int tuyenId;
                do {
                    tuyenId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < tuyens.length; k++) {
                        if (tuyens[k] != null && tuyens[k].getIdTuyen() == tuyenId && tuyenId1 != tuyenId) {
                            tuyen = tuyens[k];
                            tuyenId1 = tuyenId;
                            break;
                        }
                    }
                    if (tuyen != null) {
                        break;
                    }
                    System.out.print("Nh???p m?? sai, h??y nh???p l???i: ");
                } while (true);

                System.out.print("Tuy???n n??y ph??n c??ng m???y l?????t: ");
                int soLuot;
                do {
                    soLuot = new Scanner(System.in).nextInt();
                    tong += soLuot;
                    if (soLuot > 0 && tong <= 15) {
                        tong1 = tong;
                        break;
                    }
                    System.out.println("Nh???p sai, h??y nh???p l???i: ");
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
        System.out.print("Nh???p s??? l?????ng tuy???n mu???n th??m v??o: ");
        int soLuongTuyen = validate();
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
        System.out.print("Nh???p s??? l?????ng t??i x??? mu???n th??m v??o: ");
        int driverNumber = validate();
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            saveDriver(driver);
        }
    }

    private static int validate() {
        int validate;
        do {
            validate = new Scanner(System.in).nextInt();
            if (validate > 0) {
                break;
            }
            System.out.print("nh???p sai, h??y nh???p l???i: ");
        } while (true);
        return validate;
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
        System.out.print("M???i b???n nh???p l???a ch???n: ");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 9) {
                break;
            }
            System.out.print("nh???p sai, h??y nh???p l???i: ");
        } while (true);
        return temp;
    }

    private static void printMenu() {
        System.out.println("============== Ph???n M???m Qu???n L?? L??i Xe Bu??t ==============");
        System.out.println("1. Nh???p danh s??ch l??i xe m???i.");
        System.out.println("2. In danh s??ch l??i xe m???i.");
        System.out.println("3. Nh???p danh s??ch tuy???n xe m???i.");
        System.out.println("4. In danh s??ch tuy???n xe m???i.");
        System.out.println("5. Nh???p danh s??ch ph??n c??ng cho m???i l??i xe.");
        System.out.println("6. S???p x???p danh s??ch ph??n c??ng theo t??n l??i xe.");
        System.out.println("7. S???p x???p danh s??ch ph??n c??ng theo s??? l?????ng tuy???n gi???m d???n.");
        System.out.println("8. L???p b???ng k?? khai t???ng kho???ng c??ch ch???y xe.");
        System.out.println("9. Tho??t");
    }
}
