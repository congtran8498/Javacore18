public class BaiTap3 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int c = 4;
        int d = 6;
        int max1 = Math.max(a,b);
        int max2 = Math.max(max1,c);
        int max3 = Math.max(max2,d);
        System.out.println("số lớn nhất trong 4 số " +a+","+b+","+c+","+d+ " là " +max3);
    }
}
