import java.util.Scanner;

public class bt5a {
    public static void main(String[] args) {
        System.out.println("nhập chuỗi kí tự : ");
        String s = new Scanner(System.in).nextLine();

        System.out.println("nhập kí tự tìm kiếm : ");
        String s1 = new Scanner(System.in).nextLine();

        int s2 = s.indexOf(s1);
        int s3 = s.lastIndexOf(s1);

        System.out.println("vị trí xuất hiện đầu tiên là: " + s2 + " ví trí xuất hiện cuối cùng là: " + s3);
    }
}
