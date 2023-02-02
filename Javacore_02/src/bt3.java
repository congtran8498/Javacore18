import java.util.Scanner;

public class bt3 {
    public static void main(String[] args) {
        System.out.print("Xin mời nhập chiều dài hcn : ");
        float a = new Scanner(System.in).nextFloat();

        System.out.print("Xin mời nhập chiều rộng hcn : ");
        float b = new Scanner(System.in).nextFloat();

        float chuVi = (a + b) * 2;
        float dienTich = a * b;

        System.out.println("Chu vi của hcn có chiều dài " + a + " ,chiều rộng " + b + " là :" + chuVi);
        System.out.println("Diện tích của hcn có chiều dài " + a + " ,chiều rộng " + b + " là :" + dienTich);
    }
}
