import java.util.Scanner;

public class bt5 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        timSoLonThu2(a);
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

    public static void timSoLonThu22(int[] a) {
        if (a.length < 2) {
            System.out.println("khong ton tai so lon thu 2");
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        if (a[a.length - 2] != a[a.length - 1]) {
            System.out.println("so lon thu 2 la " + a[a.length - 2] + " co vi tri la " + (a.length - 2));
        } else {
            System.out.println("khong ton tai so lon thu 2");
        }
    }

    public static void timSoLonThu2(int[] a) {
        int max1 = a[0];
        int viTri1 = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max1) {
                max1 = a[i];
                viTri1 = i;
            }
        }
        int max2 = a[0];
        int viTri2 = 0;
        for (int i = 1; i < a.length; i++) {
            if (i != viTri1) {
                if (a[i] > max2) {
                    max2 = a[i];
                    viTri2 = i;
                }
            }
        }
        if(max1==max2){
            System.out.println("khong co so lon thu2");
        }else {
            System.out.println("so lon thu 2 la "+max2+" o vi tri "+viTri2);
        }
    }
}
