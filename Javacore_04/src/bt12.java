import java.util.Scanner;

public class bt12 {
    public static void main(String[] args) {
        int dong = nhapSo("nhap dong: ");
        int cot = nhapSo("nhap cot: ");
        int[][] a = nhapMaTran(dong, cot);
        int cot2 = nhapSo("nhap cot: ");
        int[][] b = nhapMaTran(cot,cot2);
        inMaTran(a);
        inMaTran(b);
        System.out.println("tich 2 ma tran");
        nhanMaTran(a,b);
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
    public static void nhanMaTran(int[][] a, int[][] b){
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        inMaTran(c);
    }
}
