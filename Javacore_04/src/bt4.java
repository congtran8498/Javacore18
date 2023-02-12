import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        System.out.println("co "+demSo(a)+" cap");
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



    public static int demSo(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
