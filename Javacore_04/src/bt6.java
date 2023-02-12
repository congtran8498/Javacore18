import java.util.Scanner;

public class bt6 {
    public static void main(String[] args) {
        int n = nhapSo("nhap so phan tu cua mang:");
        int[] a = nhapMang(n);
        xuatMang(a);
        int b = nhapSo("nhap so b: ");
        int c = nhapSo("nhap so c: ");
        tinhTBC(a,b,c);

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
    public static void tinhTBC(int[] a, int b, int c){
        int s=0;
        for (int i = b; i <=c ; i++) {
            s=s+a[i];
        }
        System.out.println("trung binh cong trong khoang tu "+b+" den "+c+" la "+ (float)s/(c-b+1));
    }
}
