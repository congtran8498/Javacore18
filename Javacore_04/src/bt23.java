import java.util.Scanner;

public class bt23 {
    public static void main(String[] args) {
        int dong = nhapSo("nhap dong: ");
        int cot = nhapSo("nhap cot: ");
        int[][] a = nhapMaTran(dong, cot);
        inMaTran(a);
        timMaxVaMin(a);
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

    public static void timMaxVaMin(int[][] a) {
        int max = a[0][0];
        int min = a[2][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
                if (min > a[i][j]) {
                    min = a[i][j];
                }
            }
        }
        System.out.println("gia tri lon nhat trong ma tran la " + max);
        System.out.println("gia tri nho nhat trong ma tran la " + min);
    }
}
