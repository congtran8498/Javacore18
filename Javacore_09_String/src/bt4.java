import java.util.Scanner;
import java.util.StringTokenizer;

public class bt4 {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi: ");
        String s = new Scanner(System.in).nextLine();
        chuyenDang(s);
    }

    private static void chuyenDang(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int max=0;
        int viTri=0;
        int viTriMax=0;
        int lengthSt = 0;
        while (st.hasMoreTokens()){
            lengthSt = st.nextToken().length();
            if(lengthSt > max){
                max =lengthSt;
                viTriMax=viTri;
            }
            viTri++;
        }
        System.out.println("từ dài nhất có độ dài: "+max+" tại vị trí: "+viTriMax);
    }
}
