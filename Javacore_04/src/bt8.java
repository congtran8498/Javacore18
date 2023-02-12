import java.util.Scanner;

public class bt8 {
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
            if (i != arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void dem(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(a[i] == a[j]){
                    b[i]++;
                }
            }
        }
        int max = b[0];
        for (int i = 1; i < b.length; i++) {
            if(max < b[i]) {
                max = b[i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if(b[i] == max){
                System.out.println("phan tu "+a[i]+" xuat hien nhieu nhat voi so lan la: "+max);
            }
        }
    }
}
