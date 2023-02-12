public class bt1 {
    public static void main(String[] args) {
        for (int i = 1000000; i < 1000000000; i++) {
            if (kiemTraSoCoChua068(i) && kiemTraSoThuanNghich(i) && kiemTraSoChiaHetCho10(i)) {
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
        if (soDao == n) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean kiemTraSoCoChua068(int n) {
        while (n > 0) {
            int chiaDu = n % 10;
            if (chiaDu != 0 && chiaDu != 6 && chiaDu != 8) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static boolean kiemTraSoChiaHetCho10(int n) {
        int s = 0;
        while (n > 0) {
            s = s + n % 10;
            n = n / 10;
        }
        if (s % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
