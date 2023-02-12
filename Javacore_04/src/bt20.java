import java.util.Scanner;

public class bt20 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        timSoLonNhat(a);
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

    public static void timSoLonNhat(int[] a) {
        int max = a[0];
        int viTri = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                viTri = i;
            }
        }
        System.out.println("so lon nhat la: " + max + " va vi tri xuat hien dau tien la: " + viTri);
    }
}
