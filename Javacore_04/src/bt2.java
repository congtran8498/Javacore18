public class bt2 {
    public static void main(String[] args) {
        for (int i = 1000000; i < 10000000; i++) {
            if(kiemTraSNT(i) && tongCacSolaSNT(i) && soDaolaSNT(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean kiemTraSNT(int n) {
        int canBacHai = (int) Math.sqrt(n);
        for (int i = 2; i <= canBacHai; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean tongCacSolaSNT(int n) {
        int s = 0;
        while (n > 0) {
            s = s + n % 10;
            n = n / 10;
        }
        int canBacHai = (int) Math.sqrt(s);
        for (int i = 2; i < canBacHai; i++) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean soDaolaSNT(int n){
        int m=n;
        int soDao = 0;
        while(m>0){
            soDao = soDao*10+m%10;
            m=m/10;
        }
        int canBacHai = (int) Math.sqrt(soDao);
        for (int i = 2; i < canBacHai; i++) {
            if (soDao % i == 0) {
                return false;
            }
        }
        return true;
    }
}
