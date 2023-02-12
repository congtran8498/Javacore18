public class bt13 {
    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i++) {
            if (kiemTraSoThuanNghich(i) && kiemTraSoChiaHetCho10(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean kiemTraSoThuanNghich(int n) {
        int m = n;
        int soDao = 0;
        while (m > 0) {
            soDao = soDao * 10 + m % 10;
            m = m / 10;
        }
        if (soDao != n) {
            return false;
        }
        return true;
    }

    public static boolean kiemTraSoChiaHetCho10(int n) {
        int s = 0;
        while (n > 0) {
            s = s + n % 10;
            n = n / 10;
        }
        if (s % 10 != 0) {
            return false;
        }
        return true;
    }
}
