import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {

        System.out.print("Xin mời nhập số a : ");
        float a = new Scanner(System.in).nextFloat();

        System.out.print("Xin mời nhập số b : ");
        float b = new Scanner(System.in).nextFloat();

        System.out.printf("nghiệm của phương trình %.3f*x + %.3f = 0 là %.3f ", a, b, (-b / a));
    }
}
