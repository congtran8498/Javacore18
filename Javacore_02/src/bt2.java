import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {

        System.out.print("Xin mời nhập số a : ");
        float a = new Scanner(System.in).nextFloat();

        System.out.print("Xin mời nhập số b : ");
        float b = new Scanner(System.in).nextFloat();

        System.out.print("Xin mời nhập số c : ");
        float c = new Scanner(System.in).nextFloat();

        String delta = (Math.pow(b, 2) - 4 * a * c == 0) ?
                "Phương trình có nghiệm kép là " + (-b / 2 * a) :
                (Math.pow(b, 2) - 4 * a * c < 0) ? "phương trình vô nghiệm" :
                        "phương trình có 2 nghiệm là x1 = " + (-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a) +
                                " x2 = " + (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
        System.out.println(delta);
    }
}
