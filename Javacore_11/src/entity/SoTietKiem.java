package entity;

import java.io.Serializable;

public class SoTietKiem implements Serializable {
    private int id;
    private static int AUTO_ID = 1;
    public void nhapSo(){
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "id=" + id +
                '}';
    }
}
