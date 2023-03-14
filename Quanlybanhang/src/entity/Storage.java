package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Storage implements Inputable, Serializable {
    private int idStorage;
    private String address;


    public int getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(int idStorage) {
        this.idStorage = idStorage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "idStorage=" + idStorage +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập địa chỉ kho hàng: ");
        this.address = new Scanner(System.in).nextLine();
    }
}
