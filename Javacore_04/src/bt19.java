import java.util.Scanner;

public class bt19 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        tinhTBC(a);
    }
    public static int nhapSo(String thongDiep) {
        System.out.print(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static int[] nhapMang(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nhapSo("a[" + i + "]: ");
        }
        return arr;
    }

    public static void xuatMang(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void tinhTBC(int[] n){
        int s=0;
        for (int i = 0; i < n.length; i++) {
            s=s+n[i];
        }
        float tbc = (float) s/n.length;
        System.out.println("trung binh cong cac phan tu la :"+tbc);
    }
}
