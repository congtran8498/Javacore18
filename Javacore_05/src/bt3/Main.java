package bt3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();

        System.out.println("nhap chieu dai cua hcn: ");
        double w = new Scanner(System.in).nextDouble();
        System.out.println("nhap chieu rong cua hcn: ");
        double h = new Scanner(System.in).nextDouble();
        System.out.println("nhap mau sac cua hcn: ");
        String c = new Scanner(System.in).nextLine();

        rec.setWidth(w);
        rec.setHeight(h);
        rec.setColor(c);

        System.out.println("hcn co kich thuoc chieu dai: "+rec.getWidth()+" chieu rong: "+rec.getHeight()+" va mau sac: "+ rec.getColor());
        System.out.println("hcn co chu vi la: "+rec.findPerimeter()+" va dien tich la: "+rec.findArea());
    }
}
