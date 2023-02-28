public class bt1 {
    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i++) {
            if (isThuanNghich(i)) {
                System.out.println("Số thuận nghịch là: " + i);
            }
        }
    }

    public static boolean isThuanNghich(int n) {
        String str = String.valueOf(n);
        int strSize = str.length();
        for (int i = 0; i < strSize; i++) {
            if (str.charAt(i) != str.charAt(strSize - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
