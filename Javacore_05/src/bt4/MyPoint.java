package bt4;

import java.util.Scanner;

public class MyPoint {
    double x;
    double y;

    public MyPoint(){
    }
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    public MyPoint(MyPoint p){
        x= p.x;
        y= p.y;
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void nhapToaDo(){
        System.out.println("nhap hoanh do x: ");
        this.x = new Scanner(System.in).nextDouble();

        System.out.println("nhap tung do y: ");
        this.y = new Scanner(System.in).nextDouble();
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distance(MyPoint secondPoint) {
        return Math.sqrt(Math.pow(x-secondPoint.x,2)+Math.pow(y- secondPoint.y,2));
    }
    public double distance(MyPoint p1, MyPoint p2){
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }

}
