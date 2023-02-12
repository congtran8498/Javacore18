import java.util.Scanner;

public class bt25 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        dem(a);
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
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void dem(int[] a) {
        int dem1 = 0;
        int dem2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                dem1++;
            } else {
                dem2++;
            }
        }
        System.out.println("trong mang co " + dem1 + " phan tu chan va " + dem2 + " phan tu le");
    }
}
