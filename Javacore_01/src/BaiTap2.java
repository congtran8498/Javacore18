public class BaiTap2 {
    public static void main(String[] args) {
        int r = 4;
        float chuVi = (float) ((r*2)*Math.PI);
        float dienTich = (float) (Math.pow(r,2)*Math.PI);
        System.out.println("chu vi của hình tròn có bán kính " +r+ " là " +chuVi);
        System.out.println("diện tích của hình tròn có bán kính " +r+ " là " +dienTich);
    }
}
