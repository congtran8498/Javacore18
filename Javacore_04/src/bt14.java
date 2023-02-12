import java.util.Scanner;

public class bt14 {
    public static void main(String[] args) {
        int m = nhapSo("nhap so m: ");
        int n = nhapSo("nhap so n: ");
        kiemTraSoChinhPhuong(m,n);
    }

    public static int nhapSo(String thongDiep) {
        System.out.println(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static void kiemTraSoChinhPhuong(int m, int n) {
        int count = 0;
        for (int i = m; i <= n; i++) {
            if(i>0){
                int ketQua =(int) Math.sqrt(i);
                if(ketQua*ketQua== i){
                    System.out.println(i+" la so chinh phuong");
                    count++;
                }
            }
        }
        System.out.println("tong cac so chinh phuong trong khoang tu "+m+" den "+n+" la "+count);
    }
}
