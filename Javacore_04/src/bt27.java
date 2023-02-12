import java.util.Scanner;

public class bt27 {
    public static void main(String[] args) {
        int dong = nhapSo("nhap dong: ");
        int cot = nhapSo("nhap cot: ");
        int[][] a = nhapMaTran(dong, cot);
        inMaTran(a);
        tongDuongCheoChinh(a);
    }

    public static int nhapSo(String thongDiep) {
        System.out.print(thongDiep);
        return new Scanner(System.in).nextInt();
    }

    public static int[][] nhapMaTran(int dong, int cot) {
        int[][] a = new int[dong][cot];
        for (int i = 0; i < dong; i++) {
            for (int j = 0; j < cot; j++) {
                a[i][j] = nhapSo("a[" + i + "][" + j + "]: ");
            }
        }
        return a;
    }

    public static void inMaTran(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void tongDuongCheoChinh(int[][] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == j) {
                    s += a[i][j];
                }
            }
        }
        System.out.println("tong duong cheo chinh cua ma tran: " + s);
    }
}
