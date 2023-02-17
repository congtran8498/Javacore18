package bt4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("nhap so luong doi tuong: ");
        int n = new Scanner(System.in).nextInt();
        MyPoint[] p = new MyPoint[n];

        for (int i = 0; i <p.length ; i++) {
            System.out.println("-------------------------");
            p[i] = new MyPoint();
            p[i].nhapToaDo();
        }
        System.out.println(Arrays.toString(p));
        double max = 0;
        MyPoint p1 = p[0];
        MyPoint p2 = p[0];

        for (int i = 0; i < p.length-1; i++) {
            for (int j = 0; j < p.length; j++) {
                double temp = p[j].distance(p[i]);
                if(temp > max){
                    max = temp;
                    p1 = p[i];
                    p2 = p[j];
                }
            }
        }
        System.out.println("khoang cach giua 2 diem "+p1+" va "+p2+" la khoach cac lon nhat "+max);
    }
}
