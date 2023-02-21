package entity;

import constant.DriverLevel;

import java.util.Scanner;

public class Driver extends Person {
    private int idDriver;
    private DriverLevel driverLevel;
    private static int AUTO_ID = 10000;

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public DriverLevel getDriverLevel() {
        return driverLevel;
    }

    public void setDriverLevel(DriverLevel driverLevel) {
        this.driverLevel = driverLevel;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "idDriver=" + idDriver +
                ", driverLevel=" + driverLevel +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.idDriver = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập trình độ của lái xe: ");
        System.out.println("1. Loại A");
        System.out.println("2. Loại B");
        System.out.println("3. Loại C");
        System.out.println("4. Loại D");
        System.out.println("5. Loại E");
        System.out.println("6. Loại F");
        int temp;
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 6) {
                break;
            }
            System.out.print("Nhập sai, hãy nhập lại: ");
        } while (true);
        switch (temp){
            case 1:
                this.driverLevel = DriverLevel.LOAI_A;
                break;
            case 2:
                this.driverLevel = DriverLevel.LOAI_B;
                break;
            case 3:
                this.driverLevel = DriverLevel.LOAI_C;
                break;
            case 4:
                this.driverLevel = DriverLevel.LOAI_D;
                break;
            case 5:
                this.driverLevel = DriverLevel.LOAI_E;
                break;
            case 6:
                this.driverLevel = DriverLevel.LOAI_F;
                break;
        }
    }
}
