import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class bt9 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang: ");
        int[] a = themNgauNhien(n);
        xuatMang(a);
        int[] b = inPhanTuKoTrungNhau(a);
        xuatMang(b);

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

    public static int[] themNgauNhien(int n) {
        int[] a = new int[n];
        Random rd = new Random();
        int count = 0;
        while (count < n) {
            a[count++] = rd.nextInt(100);
        }
        return a;
    }

    public static int[] inPhanTuKoTrungNhau(int[] arr) {
        int [] brr = new int[arr.length];
        int bSize = 0;
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            isExist = false;
            for (int j = 0; j < bSize; j++) {
                if(arr[i] == brr[j]){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                brr[bSize++] = arr[i];
            }
        }
        return brr;
    }

    public static int nhapSo(String thongDiep) {
        System.out.print(thongDiep);
        return new Scanner(System.in).nextInt();
    }
}
