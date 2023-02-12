import java.util.Scanner;

public class bt22 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        float[] a = nhapMang(n);
        xuatMang(a);
        sapXep(a);
        xuatMang(a);
        System.out.print("nhap so can chen: ");
        float x = new Scanner(System.in).nextFloat();
        float[] kq = chenSo(a, x);
        xuatMang(kq);
    }

    public static float[] chenSo(float[] a, float x) {
        float[] ketQua = new float[a.length + 1];
        int viTri = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > x) {
                viTri = i;
                ketQua[i] = x;
                break;
            }
            ketQua[i] = a[i];
        }
        for (int i = viTri + 1; i < ketQua.length; i++) {
            ketQua[i] = a[i-1];
        }
        return ketQua;
    }

    public static int nhapSo(String thongDiep) {
        System.out.print(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static float[] nhapMang(int n) {
        float[] arr = new float[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nhapSo("a[" + i + "]: ");
        }
        return arr;
    }

    public static void xuatMang(float[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void sapXep(float[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    float temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
