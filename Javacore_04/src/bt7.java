import java.util.Scanner;

public class bt7 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        boolean a1 = mangDoiXung(a);
        if (a1) {
            System.out.println("la mang doi xung");
        } else {
            System.out.println("khong la mang doi xung");
        }
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

    public static boolean mangDoiXung(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a[a.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
