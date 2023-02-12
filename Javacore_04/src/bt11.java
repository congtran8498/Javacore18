import java.util.Scanner;

public class bt11 {
    public static void main(String[] args) {
        int dong = nhapSo("nhap dong: ");
        int cot = nhapSo("nhap cot: ");
        int[][] a = nhapMaTran(dong, cot);
        inMaTran(a);
        System.out.println("Ma tran chuyen vi");
        maTranChuyenVi(a);
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
    public static void maTranChuyenVi(int[][] a){
        int[][] chuyenVi = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                chuyenVi[j][i] = a[i][j];
            }
        }
        inMaTran(chuyenVi);
    }
}
