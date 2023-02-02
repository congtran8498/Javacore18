import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class bt4 {
    public static void main(String[] args) throws ParseException {

        System.out.println("Nhập ngày tháng năm sinh: ");
        String birthday = new Scanner(System.in).nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date parse = simpleDateFormat.parse(birthday);
        Date date = new Date();

        int age = date.getYear() - parse.getYear();
        System.out.println("Tuổi :" + age);
    }
}
